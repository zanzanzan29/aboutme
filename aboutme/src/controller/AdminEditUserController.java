package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.StringUtil;
import model.bean.User;
import model.dao.UserDAO;


public class AdminEditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;   

    public AdminEditUserController() {
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
		User item = userDAO.getItem(id);
		if(!"Admin".equals(userLogin.getChucvu())){
			if(userLogin.getId() == item.getId()){
				request.setAttribute("item", item);
				RequestDispatcher rd = request.getRequestDispatcher("/admin/user/edit.jsp");
				rd.forward(request, response);
				return;
			}else{
				response.sendRedirect(request.getContextPath() + "/admin/users?err=5");
				return;
			}
		}
		request.setAttribute("item", item);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/edit.jsp");
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
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/users?err=1");
			return;
		}
		String username = request.getParameter("name");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String chucvu = request.getParameter("chucvu");
		User item = userDAO.getItem(id);
		if("".equals(password)){
			password = item.getPassword();
		}else{
			password = StringUtil.md5(password);
		}
		User user = new User(id, username, password, fullname, chucvu);
		if(userDAO.editItem(user) > 0){
			response.sendRedirect(request.getContextPath() + "/admin/users?msg=2");
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/user/edit.jsp?err=1");
			rd.forward(request, response);
		}
	}

}
