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
import model.bean.Changduong;
import model.bean.User;
import model.dao.ChangduongDAO;
import model.dao.UserDAO;


public class AdminEditChangduongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChangduongDAO changduongDAO;   

    public AdminEditChangduongController() {
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
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/changduongs?err=1");
			return;
		}
		Changduong item = changduongDAO.getItem(id);
		request.setAttribute("item", item);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/changduong/edit.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/admin/changduongs?err=1");
			return;
		}
		String name = request.getParameter("name");
		String phanloai = request.getParameter("phanloai");
		String date = request.getParameter("date");
		String content = request.getParameter("content");
		Changduong changduong = new Changduong(id, name, date, phanloai, content);
		if(changduongDAO.editItem(changduong) > 0){
			response.sendRedirect(request.getContextPath() + "/admin/changduongs?msg=2");
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/changduong/edit.jsp?err=1");
			rd.forward(request, response);
		}
	}

}
