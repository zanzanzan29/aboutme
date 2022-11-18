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
import model.bean.Changduong;
import model.bean.User;
import model.dao.ChangduongDAO;
import model.dao.UserDAO;


public class AdminAddChangduongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChangduongDAO changduongDAO;  

    public AdminAddChangduongController() {
        super();
        changduongDAO = new ChangduongDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/changduong/add.jsp");
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
		String phanloai = request.getParameter("phanloai");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		Changduong changduong = new Changduong(0, name, date, phanloai, content);
		if(changduongDAO.addItem(changduong) > 0){
			response.sendRedirect(request.getContextPath() + "/admin/changduongs?msg=1");
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/changduong/add.jsp?err=1");
			rd.forward(request, response);
			return;
		}
	}

}
