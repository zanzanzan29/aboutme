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

import model.bean.Category;
import model.bean.Comment;
import model.bean.News;
import model.dao.CategoryDAO;
import model.dao.CommentDAO;
import model.dao.NewsDAO;


public class PublicNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;   
    private NewsDAO newsDAO;
    private CommentDAO commentDAO;
    
    public PublicNewsController() {
        super();
        categoryDAO = new CategoryDAO();
        newsDAO = new NewsDAO();
        commentDAO = new CommentDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = 0;
		int cid = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			cid = Integer.parseInt(request.getParameter("cid"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() + "/idnews");
			return;
		}
				
		News itemN = newsDAO.getItem(id);
		ArrayList<News> listNN = newsDAO.getItemsXemNhieu();
		ArrayList<News> listNC = newsDAO.getItems(cid);
		ArrayList<Category> listCat = categoryDAO.getItems();

		//tăng view
		HttpSession session = request.getSession();
		String hasVisited = (String) session.getAttribute("hasVisited: " + id);
		if(hasVisited == null){
			session.setAttribute("hasVisited: " + id, "yes");
			session.setMaxInactiveInterval(3600);
			//increase page view
			newsDAO.increaseView(id);
		}
		request.setAttribute("itemN", itemN);
		request.setAttribute("listNN", listNN);
		request.setAttribute("listNC", listNC);
		request.setAttribute("listCat", listCat);
		RequestDispatcher rd = request.getRequestDispatcher("/public/news.jsp");
		rd.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int id = 0;
		int cid = 0;
		try {
			cid = Integer.parseInt(request.getParameter("cid"));
			id = Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.sendRedirect(request.getContextPath() );
			return;
		}
		News itemN = newsDAO.getItem(id);
		ArrayList<News> listNN = newsDAO.getItemsXemNhieu();
		ArrayList<Category> listCat = categoryDAO.getItems();
		ArrayList<News> listNC = newsDAO.getItems(cid);
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		News news = new News(id, null, null, null, 0);
		Comment comment = new Comment(0, name, message, news);
		request.setAttribute("itemN", itemN);
		request.setAttribute("listNN", listNN);
		request.setAttribute("listCat", listCat);
		request.setAttribute("listNC", listNC);
		if(commentDAO.addItem(comment) > 0){
			RequestDispatcher rd = request.getRequestDispatcher("/public/news.jsp?msg=1");
			rd.forward(request, response);
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/news?err=1");
			rd.forward(request, response);
			return;
		}
	}

}
