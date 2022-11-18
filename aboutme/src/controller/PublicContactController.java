package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Contact;
import model.dao.ContactDAO;


public class PublicContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ContactDAO contactDAO;   

    public PublicContactController() {
        super();
        contactDAO = new ContactDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath() + "/#rsvp" );
		return;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		String email = request.getParameter("email");
		String diachi = request.getParameter("diachi");
		String message = request.getParameter("message");
		Contact contact = new Contact(0, name, email, diachi, phone, message);
		if(contactDAO.addItem(contact) > 0){
			response.sendRedirect(request.getContextPath() + "/lienhe/thanhcong-1.html#rsvp");
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/lienhe/thatbai-1.html#rsvp");
			rd.forward(request, response);
			return;
		}
	}

}
