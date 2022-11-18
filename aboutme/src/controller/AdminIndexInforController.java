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
import model.bean.Information;
import model.bean.User;
import model.dao.InformationDAO;


public class AdminIndexInforController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private InformationDAO informationDAO;   

    public AdminIndexInforController() {
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
		int numberOfItems = informationDAO.countItems();
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<Information> listInfor = informationDAO.getItems(offset);
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listInfor", listInfor);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/infor/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		int trangthai = Integer.parseInt(request.getParameter("atrangthai"));
		int iid = Integer.parseInt(request.getParameter("aiid"));
		if(informationDAO.trangthai() > 0){
			System.out.println("cho tất cả trạng thái về 0");
		}else{
			System.out.println("lỗi");
		}
		if(informationDAO.trangthai(iid,trangthai) > 0){
			System.out.println("Thành công");
		}else{
			System.out.println("Có lỗi");
		}
		if(trangthai == 1){
			out.print(
					"<a href=\"javascript:void(0)\" title=\"\" class=\"btn btn-primary sua\" style=\"background: #00FFFF; border:1px solid #00FFFF\">" + "Đang hiển thị"+"</a>"
					);
		}else{
		}
		
	}

}
