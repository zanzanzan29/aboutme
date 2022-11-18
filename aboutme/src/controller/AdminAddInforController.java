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


public class AdminAddInforController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InformationDAO informationDAO;   

    public AdminAddInforController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/admin/infor/add.jsp");
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
		Information information = new Information(0, name, date, email, diachi, phone, gioithieu, 0);
		if(informationDAO.addItem(information) > 0){
			response.sendRedirect(request.getContextPath() + "/admin/infors?msg=1");
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/infor/add.jsp?err=1");
			rd.forward(request, response);
		}
	}

}
