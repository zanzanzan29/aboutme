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

public class CategoryDAO {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ArrayList<Category> getItems() {
		ArrayList<Category> listCat = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM categories ORDER BY Id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				Category items = new Category(id, name);
				listCat.add(items);
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
		return listCat;
	}

	public int addItem(String name) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO categories(Name) VALUES (?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, name);
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

	public Category getItem(int id) {
		Category category = null;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM categories WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				String name = rs.getString("Name");
				category = new Category(id, name);
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
		return category;
	}

	public int editItem(Category item) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "UPDATE categories SET Name = ? WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, item.getName());
			pst.setInt(2, item.getId());
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
		String query = "DELETE FROM categories WHERE Id = ?";
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
		String query = "SELECT COUNT(Id) as tong FROM categories";
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

	public ArrayList<Category> getItems(int offset) {
		ArrayList<Category> listCat = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM categories ORDER BY Id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				Category items = new Category(id, name);
				listCat.add(items);
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
		return listCat;
	}
}
