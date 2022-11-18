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

import util.DefineUtil;
import model.bean.Changduong;
import model.bean.User;
import model.dao.ChangduongDAO;
import model.dao.UserDAO;


public class AdminIndexChangduongController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ChangduongDAO changduongDAO;

    public AdminIndexChangduongController() {
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
		int numberOfItems = changduongDAO.countItems();
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Changduong> listCd = changduongDAO.getItems(offset);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listCd", listCd);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/changduong/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
