package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.Information;
import model.bean.User;
import model.dao.InformationDAO;


public class AdminEditInforController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InformationDAO informationDAO;  
 
    public AdminEditInforController() {
        super();
        informationDAO = new InformationDAO();
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
			response.sendRedirect(request.getContextPath() + "/admin/infors?err=1");
			return;
		}
		Information item = informationDAO.getItem(id);
		request.setAttribute("item", item);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/infor/edit.jsp");
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
			response.sendRedirect(request.getContextPath() + "/admin/infors?err=1");
			return;
		}
		String name = request.getParameter("name");
		String date = request.getParameter("date");
		String diachi = request.getParameter("diachi");
		int phone = 0;
		try {
			phone = Integer.parseInt(request.getParameter("phone"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/infor/add.jsp?err=2");
			rd.forward(request, response);
			return;
		}
		
		
		String email = request.getParameter("email");
		String gioithieu = request.getParameter("gioithieu");
		Information information = new Information(id, name, date, email, diachi, phone, gioithieu, 0);
		if(informationDAO.editItem(information) > 0){
			response.sendRedirect(request.getContextPath() + "/admin/infors?msg=2");
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/infor/edit.jsp?err=1");
			rd.forward(request, response);
		}
	}

}
