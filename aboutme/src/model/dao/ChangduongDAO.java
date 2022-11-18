package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBConnectionUtil;
import util.DefineUtil;
import model.bean.Changduong;
import model.bean.User;

public class ChangduongDAO {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ArrayList<Changduong> getItems() {
		ArrayList<Changduong> listCd = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM chanduong";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String date = rs.getString("Date");
				String phanloai = rs.getString("Classify");
				String content = rs.getString("Content");
				Changduong changduong = new Changduong(id, name, date, phanloai, content);
				listCd.add(changduong);
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
		return listCd;
	}

	public int addItem(Changduong changduong) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO chanduong(Name,Date,Classify,Content) VALUES (?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, changduong.getName());
			pst.setString(2, changduong.getDate());
			pst.setString(3, changduong.getPhanloai());
			pst.setString(4, changduong.getContent());
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

	public Changduong getItem(int id) {
		Changduong item = null;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM chanduong WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				String name = rs.getString("Name");
				String date = rs.getString("Date");
				String phanloai = rs.getString("Classify");
				String content = rs.getString("Content");
				item = new Changduong(id, name, date, phanloai, content);
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

	public int editItem(Changduong changduong) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "UPDATE chanduong SET Name = ?, Date = ?, Classify = ?, Content= ? WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, changduong.getName());
			pst.setString(2, changduong.getDate());
			pst.setString(3, changduong.getPhanloai());
			pst.setString(4, changduong.getContent());
			pst.setInt(5, changduong.getId());
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
		String query = "DELETE FROM chanduong WHERE Id = ?";
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
		String query = "SELECT COUNT(Id) AS tong FROM chanduong";
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

	public ArrayList<Changduong> getItems(int offset) {
		ArrayList<Changduong> listCd = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM chanduong LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String date = rs.getString("Date");
				String phanloai = rs.getString("Classify");
				String content = rs.getString("Content");
				Changduong changduong = new Changduong(id, name, date, phanloai, content);
				listCd.add(changduong);
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
		return listCd;
	}
	
}
