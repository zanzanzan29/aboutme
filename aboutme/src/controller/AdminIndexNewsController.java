package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.DefineUtil;
import model.bean.News;
import model.bean.User;
import model.dao.NewsDAO;



public class AdminIndexNewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO;   

    public AdminIndexNewsController() {
        super();
        newsDAO = new NewsDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		int numberOfItems = newsDAO.countItems();
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		ArrayList<News> listNews = newsDAO.getItemslist(offset);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listNews", listNews);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/news/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		PrintWriter out = response.getWriter();
		int trangthai = Integer.parseInt(request.getParameter("atrangthai"));
		int nid = Integer.parseInt(request.getParameter("anid"));
		if(newsDAO.TrangThai(nid, trangthai)>0){
			System.out.println("Thành công");
		}else{
			System.out.println("không");
		}
		if(trangthai == 1){
			out.print(
					"<a href=\"javascript:void(0)\" onclick=\"return getActive("+ nid +",0)\">"+
            		"<img width=\"25px\" height=\"25px\" src=\""+request.getContextPath() +"/templates/admin/assets/img/ac.png\" alt=\"\"/>"+
            		"</a>"
					);
		}else{
			out.print(
					"<a href=\"javascript:void(0)\" onclick=\"return getActive("+ nid +",1)\">"+
            		"<img width=\"25px\" height=\"25px\" src=\""+request.getContextPath() +"/templates/admin/assets/img/de.png\" alt=\"\"/>"+
            		"</a>"
					);
		}
	}

}
