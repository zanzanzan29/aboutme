package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DefineUtil;
import model.bean.Category;
import model.bean.News;
import model.dao.CategoryDAO;
import model.dao.NewsDAO;


public class PublicCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryDAO categoryDAO;   
    private NewsDAO newsDAO;  

    public PublicCatController() {
        super();
        categoryDAO = new CategoryDAO();
        newsDAO = new NewsDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/idnews");
			return;
		}
		int numberOfItems = newsDAO.countItems(id);
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		Category cat = categoryDAO.getItem(id);
		ArrayList<News> listNN = newsDAO.getItemsXemNhieu();
		ArrayList<News> listNC = newsDAO.getItems(id,offset);
		ArrayList<Category> listCat = categoryDAO.getItems();
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listNN", listNN);
		request.setAttribute("cat", cat);
		request.setAttribute("listNC", listNC);
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/public/cat.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
