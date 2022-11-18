package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.News;
import model.bean.User;
import model.dao.NewsDAO;


public class AdminDelNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO;  

    public AdminDelNewsController() {
        super();
        newsDAO = new NewsDAO();
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
		//get bài hát với id hiện tại
		News news = newsDAO.getItem(id);
		if(news == null){
			response.sendRedirect(request.getContextPath() + "/admin/newss?err=3");
			return;
		}
		
		if(newsDAO.delItem(id) > 0){
			//thành công
			
			//xóa ảnh
			final String dirPathName = request.getServletContext().getRealPath("/files");
			String picture = news.getPicture();
			if(!picture.isEmpty()){
				String filePathName = dirPathName + File.separator + picture;
				File file = new File(filePathName);
				if(file.exists()){
					file.delete();
				}
			}
			
			
			response.sendRedirect(request.getContextPath() + "/admin/newss?msg=3");
			return;
		}else{
			//thất bại
			response.sendRedirect(request.getContextPath() + "/admin/newss?err=2");
			return;
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
