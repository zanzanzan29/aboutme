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
import model.bean.Project;
import model.bean.User;
import model.dao.NewsDAO;
import model.dao.ProjectDAO;


public class AdminDelProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;  

    public AdminDelProjectController() {
        super();
        projectDAO = new ProjectDAO();
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
			response.sendRedirect(request.getContextPath() + "/admin/projects?err=1");
			return;
		}
		//get dự án với id hiện tại
		Project project = projectDAO.getItem(id);
		if(project == null){
			response.sendRedirect(request.getContextPath() + "/admin/projects?err=3");
			return;
		}
		
		if(projectDAO.delItem(id) > 0){
			//thành công
			
			//xóa ảnh
			final String dirPathName = request.getServletContext().getRealPath("/files");
			String picture = project.getPicture();
			if(!picture.isEmpty()){
				String filePathName = dirPathName + File.separator + picture;
				File file = new File(filePathName);
				if(file.exists()){
					file.delete();
				}
			}
			
			
			response.sendRedirect(request.getContextPath() + "/admin/projects?msg=3");
			return;
		}else{
			//thất bại
			response.sendRedirect(request.getContextPath() + "/admin/projects?err=2");
			return;
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
