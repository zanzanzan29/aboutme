package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBConnectionUtil;
import util.DefineUtil;
import model.bean.Category;
import model.bean.News;
import model.bean.Project;

public class ProjectDAO {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ArrayList<Project> getItems() {
		ArrayList<Project> listProject = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM project ORDER BY Id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String link = rs.getString("Link");
				String picture = rs.getString("Picture");
				Project project = new Project(id, name, link, picture);
				listProject.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs != null && st != null && conn != null){
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listProject;
	}

	public int addItem(Project project) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO project(Name,Link,Picture) VALUES (?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, project.getName());
			pst.setString(2, project.getLink());
			pst.setString(3, project.getPicture());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(pst != null && conn != null){
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public Project getItem(int id) {
		Project item = null;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM project WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				String name = rs.getString("Name");
				String link = rs.getString("Link");
				String picture = rs.getString("Picture");
				item = new Project(id, name, link, picture);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs != null && pst != null && conn != null){
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return item;
	}

	public int editItem(Project project) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "UPDATE project SET Name = ? ,Link = ?,Picture = ? WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, project.getName());
			pst.setString(2, project.getLink());
			pst.setString(3, project.getPicture());
			pst.setInt(4, project.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(pst != null && conn != null){
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int delItem(int id) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "DELETE FROM project WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(pst != null && conn != null){
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	public int countItems() {
		int a = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(Id) as tong FROM project";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if(rs.next()){
				a = rs.getInt("tong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs != null && st != null && conn != null){
				try {
					rs.close();
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return a;
	}

	public ArrayList<Project> getItems(int offset) {
		ArrayList<Project> listProject = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM project ORDER BY Id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String link = rs.getString("Link");
				String picture = rs.getString("Picture");
				Project project = new Project(id, name, link, picture);
				listProject.add(project);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs != null && pst != null && conn != null){
				try {
					rs.close();
					pst.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return listProject;
	}
	
	
}
