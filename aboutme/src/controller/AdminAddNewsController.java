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
public class AdminAddNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;
    private NewsDAO newsDAO;

    public AdminAddNewsController() {
        super();
        categoryDAO = new CategoryDAO();
        newsDAO = new NewsDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		ArrayList<Category> categories = categoryDAO.getItems();
		if(categories.size() == 0){
			response.sendRedirect(request.getContextPath() + "/admin/newss?err=3");
			return;
		}
		request.setAttribute("categories", categories);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/news/add.jsp");
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
		int cat = 0;
		try {
			cat = Integer.parseInt(request.getParameter("cat"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/newss?err=3");
			return;
		}
		String nguoiviet = userLogin.getChucvu();
		String name = request.getParameter("name");
		String mota = request.getParameter("mota");
		String chitiet = request.getParameter("chitiet");
		Category category = new Category(cat, null);
		Part filePart = request.getPart("picture");
		// tạo thư mục lưu ảnh
		final String dirPathName = request.getServletContext().getRealPath("/files");
		File dirFile = new File(dirPathName);
		if(!dirFile.exists()){
			dirFile.mkdirs();
		}
		
		// lấy tên file từ part
		String fileName = FileUtil.getName(filePart);
		// đổi tên file
		String picture = FileUtil.rename(fileName);
		// đường dẫn file
		String filePathName = dirPathName + File.separator + picture;
		News news = new News(0, name, category, picture, 0, mota, chitiet, 0, nguoiviet);
		if(newsDAO.addItem(news) > 0){
			//ghi file
			if(!fileName.isEmpty()){
				filePart.write(filePathName);
			}
			response.sendRedirect(request.getContextPath() + "/admin/newss?msg=1");
			return;
		}else{
			ArrayList<Category> categories = categoryDAO.getItems();
			request.setAttribute("categories", categories);
			RequestDispatcher rd = request.getRequestDispatcher("/admin/news/add.jsp?err=1");
			rd.forward(request, response);
		}
	}

}
