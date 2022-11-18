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
import model.bean.Category;
import model.bean.User;
import model.dao.CategoryDAO;


public class AdminIndexCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;   

    public AdminIndexCatController() {
        super();
        categoryDAO = new CategoryDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int numberOfItems = categoryDAO.countItems();
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Category> listCat = categoryDAO.getItems(offset);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
