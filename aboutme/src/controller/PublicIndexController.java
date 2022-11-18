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
import model.bean.Changduong;
import model.bean.Information;
import model.bean.News;
import model.bean.Project;
import model.bean.Skill;
import model.dao.ChangduongDAO;
import model.dao.InformationDAO;
import model.dao.NewsDAO;
import model.dao.ProjectDAO;
import model.dao.SkillDAO;


public class PublicIndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private NewsDAO newsDAO;  
    private ChangduongDAO changduongDAO;
    private ProjectDAO projectDAO;
    private SkillDAO skillDAO;
    private InformationDAO informationDAO;
    
    public PublicIndexController() {
        super();
        newsDAO = new NewsDAO();
        changduongDAO = new ChangduongDAO();
        projectDAO = new ProjectDAO();
        skillDAO = new SkillDAO();
        informationDAO = new InformationDAO();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numberOfItems = newsDAO.countItemsTT();
		int numberOfPages = (int) Math.ceil((float) numberOfItems / DefineUtil.NUMBER_PER_PAGE);
		int currentPage = 1;
		try {
			currentPage = Integer.parseInt(request.getParameter("page"));
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		int offset = (currentPage - 1) * DefineUtil.NUMBER_PER_PAGE;
		
		ArrayList<News> listNews = newsDAO.getItemsTT(offset);
		ArrayList<Changduong> listCd = changduongDAO.getItems();
		ArrayList<Project> listProject = projectDAO.getItems();
		ArrayList<Skill> listSkill = skillDAO.getItems();
		Information listInfo = informationDAO.getItem();
		request.setAttribute("numberOfPages", numberOfPages);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("listInfo", listInfo);
		request.setAttribute("listSkill", listSkill);
		request.setAttribute("listProject", listProject);
		request.setAttribute("listCd", listCd);
		request.setAttribute("listNews", listNews);
		request.setAttribute("home", "#home");
		request.setAttribute("about", "#about");
		request.setAttribute("exp", "#story");
		request.setAttribute("project", "#gallery");
		request.setAttribute("skill", "#event");
		request.setAttribute("idnews", "#family");
		request.setAttribute("contact", "#rsvp");
		RequestDispatcher rd = request.getRequestDispatcher("/public/index.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
