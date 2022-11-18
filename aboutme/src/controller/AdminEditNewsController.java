package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import util.FileUtil;
import model.bean.Category;
import model.bean.News;
import model.bean.User;
import model.dao.CategoryDAO;
import model.dao.NewsDAO;

@MultipartConfig
public class AdminEditNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO; 
    private CategoryDAO categoryDAO;

    public AdminEditNewsController() {
        super();
        newsDAO = new NewsDAO();
        categoryDAO = new CategoryDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/newss?err=1");
			return;
		}
		ArrayList<Category> categories = categoryDAO.getItems();
		News item = newsDAO.getItem(id);
		request.setAttribute("item", item);
		request.setAttribute("categories", categories);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/news/edit.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		request.setCharacterEncoding("UTF-8");
		int id = 0;
		int cat = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			cat = Integer.parseInt(request.getParameter("cat"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/newss?err=1");
			return;
		}
		
		String name = request.getParameter("name");
		String mota = request.getParameter("mota");
		String chitiet = request.getParameter("chitiet");
		Category category = new Category(cat, null);
		Part filePart = request.getPart("picture");
		News item = newsDAO.getItem(id);
		if(item == null){
			response.sendRedirect(request.getContextPath() + "/admin/newss?err=3");
			return;
		}
		// tạo thư mục lưu ảnh
		final String dirPathName = request.getServletContext().getRealPath("/files");
		File dirFile = new File(dirPathName);
		if(!dirFile.exists()){
			dirFile.mkdirs();
		}
		
		// lấy tên file từ part
		String fileName = FileUtil.getName(filePart);
		// đổi tên file
		String picture = "";
		if(fileName.isEmpty()){
			picture = item.getPicture();
		} else{
			picture = FileUtil.rename(fileName);
		}
		// đường dẫn file
		String filePathName = dirPathName + File.separator + picture;
		News news = new News(id, name, category, picture, 0, mota, chitiet) ;
		if(newsDAO.editItem(news) > 0){
			if(!fileName.isEmpty()){
				//xóa file cũ
				String oldFilePathName = dirPathName + File.separator + item.getPicture();
				File oldFile = new File(oldFilePathName);
				if(oldFile.exists()){
					oldFile.delete();
				}
				
				//ghi file
				filePart.write(filePathName);
			}
			response.sendRedirect(request.getContextPath() + "/admin/newss?msg=2");
			return;
		}else{
			ArrayList<Category> categories = categoryDAO.getItems();
			request.setAttribute("categories", categories);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/news/edit.jsp?err=1");
			rd.forward(request, response);
		}
	}

}
