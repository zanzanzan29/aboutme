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
import model.bean.User;
import model.dao.CategoryDAO;



public class AdminAddCatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CategoryDAO categoryDAO;   

    public AdminAddCatController() {
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
		RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/add.jsp");
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
		ArrayList<Category> listCat = categoryDAO.getItems();
		for(Category items: listCat){
			if(name.equals(items.getName())){
				RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/add.jsp?err=2");
				rd.forward(request, response);
				return;
			}
		}
		if(categoryDAO.addItem(name) > 0){
			response.sendRedirect(request.getContextPath() + "/admin/cats?msg=1");
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/cat/add.jsp?err=1");
			rd.forward(request, response);
			return;
		}
	}

}
