package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBConnectionUtil;
import util.DefineUtil;
import model.bean.User;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ArrayList<User> getItems() {
		ArrayList<User> listUser = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM user ORDER BY Id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("Id");
				String username = rs.getString("UserName");
				String password = rs.getString("Password");
				String fullname = rs.getString("FullName");
				String chucvu = rs.getString("Position");
				User user = new User(id, username, password, fullname, chucvu);
				listUser.add(user);
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
		return listUser;
	}

	public int addItem(User user) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO user(UserName,Password,FullName,Position) VALUES(?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getFullname());
			pst.setString(4, user.getChucvu());
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

	public User getItem(int id) {
		User item = null;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM user WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				String username = rs.getString("UserName");
				String password = rs.getString("Password");
				String fullname = rs.getString("FullName");
				String chucvu = rs.getString("Position");
				item = new User(id, username, password, fullname, chucvu);
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

	public int editItem(User user) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "UPDATE user SET Password = ? ,FullName = ?, Position = ? WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, user.getPassword());
			pst.setString(2, user.getFullname());
			pst.setString(3, user.getChucvu());
			pst.setInt(4, user.getId());
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
		String query = "DELETE FROM user WHERE Id = ?";
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

	public User kiemtra(String username, String password) {
		User item = null;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM user WHERE UserName = ? AND Password = ? ";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, username);
			pst.setString(2, password);
			rs = pst.executeQuery();
			if(rs.next()){
				int id = rs.getInt("Id");
				String fullname = rs.getString("FullName");
				String chucvu = rs.getString("Position");
				item = new User(id, username, password, fullname, chucvu);
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

	public int countItems() {
		int a = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(Id) as tong FROM user";
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

	public ArrayList<User> getItems(int offset) {
		ArrayList<User> listUser = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM user ORDER BY Id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("Id");
				String username = rs.getString("UserName");
				String password = rs.getString("Password");
				String fullname = rs.getString("FullName");
				String chucvu = rs.getString("Position");
				User user = new User(id, username, password, fullname, chucvu);
				listUser.add(user);
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
		return listUser;
	}
	
	
}
