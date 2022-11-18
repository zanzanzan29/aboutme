package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBConnectionUtil;
import util.DefineUtil;
import model.bean.Comment;
import model.bean.News;

public class CommentDAO {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement st;
	
	public ArrayList<Comment> getItems() {
		ArrayList<Comment> listItem = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT c.Id AS cid ,n.Id AS nid, n.Name As nname , c.Name As cname , Message "
				+ "FROM comment AS c "
				+ "INNER JOIN news AS n "
				+ "ON c.Id_N = n.Id "
				+ "ORDER BY c.Id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("cid");
				String name = rs.getString("cname");
				String message = rs.getString("Message");
				News news = new News(rs.getInt("nid"), rs.getString("nname"), null, null, 0, null, null);
				Comment comment = new Comment(id, name, message, news);
				listItem.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs!= null && st != null && conn != null){
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
		return listItem;
	}

	public int delItem(int id) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "DELETE FROM comment WHERE Id = ?";
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

	public int addItem(Comment comment) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO comment(Id_N,Name,Message) VALUES (?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, comment.getNews().getId());
			pst.setString(2, comment.getName());
			pst.setString(3, comment.getMessage());
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
		String query = "SELECT COUNT(Id) as tong FROM comment";
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

	public ArrayList<Comment> getItems(int offset) {
		ArrayList<Comment> listItem = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT c.Id AS cid ,n.Id AS nid, n.Name As nname , c.Name As cname , Message "
				+ "FROM comment AS c "
				+ "INNER JOIN news AS n "
				+ "ON c.Id_N = n.Id "
				+ "ORDER BY c.Id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("cid");
				String name = rs.getString("cname");
				String message = rs.getString("Message");
				News news = new News(rs.getInt("nid"), rs.getString("nname"), null, null, 0, null, null);
				Comment comment = new Comment(id, name, message, news);
				listItem.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs!= null && pst != null && conn != null){
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
		return listItem;
	}
	
	
}
