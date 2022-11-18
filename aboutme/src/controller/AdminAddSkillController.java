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

import util.StringUtil;
import model.bean.Skill;
import model.bean.User;
import model.dao.SkillDAO;
import model.dao.UserDAO;


public class AdminAddSkillController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SkillDAO skillDAO;  

    public AdminAddSkillController() {
        super();
        skillDAO = new SkillDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userLogin = (User) session.getAttribute("userLogin");
		if(userLogin == null ){
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("/admin/skill/add.jsp");
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
		int value = 0;
		try {
			value = Integer.parseInt(request.getParameter("value"));
		} catch (NumberFormatException e) {
			RequestDispatcher rd = request.getRequestDispatcher("/admin/skill/add.jsp?err=3");
			rd.forward(request, response);
			return;
		}
		String name = request.getParameter("name");
		ArrayList<Skill> listSkill = skillDAO.getItems();
		for(Skill items: listSkill){
			if(name.equals(items.getName())){
				RequestDispatcher rd = request.getRequestDispatcher("/admin/skill/add.jsp?err=2");
				rd.forward(request, response);
				return;
			}
		}
		Skill skill = new Skill(0, name, value);
		if(skillDAO.addItem(skill) > 0){
			response.sendRedirect(request.getContextPath() + "/admin/skills?msg=1");
			return;
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/admin/skill/add.jsp?err=1");
			rd.forward(request, response);
			return;
		}
	}

}
