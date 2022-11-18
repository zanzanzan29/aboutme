package controller;

import java.io.IOException;
import java.util.ArrayList;

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


public class AuthLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO userDAO;   

    public AuthLoginController() {
        super();
        userDAO = new UserDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin != null ){
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/auth/login.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin != null ){
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		password = StringUtil.md5(password);
		User user = userDAO.kiemtra(username,password);
		if(user != null){
			session.setAttribute("userLogin", user);
			response.sendRedirect(request.getContextPath() + "/admin");
			return;
		}else{
			response.sendRedirect(request.getContextPath() + "/login?err=1");
			return;
		}
	}

}
