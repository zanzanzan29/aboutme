package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.User;
import model.dao.UserDAO;


public class AdminDelUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;  
 
    public AdminDelUserController() {
        super();
        userDAO = new UserDAO();
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
			response.sendRedirect(request.getContextPath() + "/admin/users?err=1");
			return;
		}
		if(!"Admin".equals(userLogin.getChucvu())){
			response.sendRedirect(request.getContextPath() + "/admin/users?err=6");
			return;
		}else{
			User item = userDAO.getItem(id);
			if("Admin".equals(item.getChucvu())){
				response.sendRedirect(request.getContextPath() + "/admin/users?err=6");
				return;
			}else{
				if(userDAO.delItem(id) > 0){
					response.sendRedirect(request.getContextPath() + "/admin/users?msg=3");
					return;
				}else{
					response.sendRedirect(request.getContextPath() + "/admin/users?err=2");
					return;
				}
			}
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
