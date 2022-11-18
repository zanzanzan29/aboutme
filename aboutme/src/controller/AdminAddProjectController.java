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
import model.bean.Project;
import model.bean.User;
import model.dao.CategoryDAO;
import model.dao.NewsDAO;
import model.dao.ProjectDAO;

@MultipartConfig
public class AdminAddProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;

    public AdminAddProjectController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/admin/project/add.jsp");
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
		String name = request.getParameter("name");
		String link = request.getParameter("link");
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
		Project project = new Project(0, name, link, picture);
		if(projectDAO.addItem(project) > 0){
			//ghi file
			if(!fileName.isEmpty()){
				filePart.write(filePathName);
			}
			response.sendRedirect(request.getContextPath() + "/admin/projects?msg=1");
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/project/add.jsp?err=1");
			rd.forward(request, response);
		}
	}

}
