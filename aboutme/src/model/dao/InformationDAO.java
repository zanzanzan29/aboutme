package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import util.DBConnectionUtil;
import util.DefineUtil;
import model.bean.Information;

public class InformationDAO {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ArrayList<Information> getItems() {
		ArrayList<Information> listInfor = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM information ORDER BY Id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String date = rs.getString("Date_Of_Birth");
				String email = rs.getString("Email");
				String diachi = rs.getString("Address");
				int phone = rs.getInt("Phone");
				String content = rs.getString("Content");
				int status = rs.getInt("Status");
				Information information = new Information(id, name, date, email, diachi, phone, content, status);
				listInfor.add(information);
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
		return listInfor;
	}

	public int trangthai() {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "UPDATE information SET Status = 0 ";
		try {
			st = conn.createStatement();
			result = st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(st != null && conn != null){
				try {
					st.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
		public int trangthai(int iid, int trangthai) {
			int result = 0;
			conn = DBConnectionUtil.getConnection();
			String query = "UPDATE information SET Status = ? WHERE Id = ?";
			try {
				pst = conn.prepareStatement(query);
				pst.setInt(1, trangthai);
				pst.setInt(2, iid);
				result = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
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

		public int addItem(Information information) {
			int result = 0;
			conn = DBConnectionUtil.getConnection();
			String query = "INSERT INTO information(Name,Date_Of_Birth,Email,Address,Phone,Content) VALUES (?,?,?,?,?,?)";
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, information.getName());
				pst.setString(2, information.getDate());
				pst.setString(3, information.getEmail());
				pst.setString(4, information.getDiachi());
				pst.setInt(5, information.getPhone());
				pst.setString(6, information.getContent());
				result = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
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

		public Information getItem(int id) {
			Information item = null;
			conn = DBConnectionUtil.getConnection();
			String query = "SELECT * FROM information WHERE Id = ?";
			try {
				pst = conn.prepareStatement(query);
				pst.setInt(1, id);
				rs = pst.executeQuery();
				if(rs.next()){
					String name = rs.getString("Name");
					String date = rs.getString("Date_Of_Birth");
					String email = rs.getString("Email");
					String diachi = rs.getString("Address");
					int phone = rs.getInt("Phone");
					String content = rs.getString("Content");
					int status = rs.getInt("Status");
					item = new Information(id, name, date, email, diachi, phone, content, status);
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

		public int editItem(Information information) {
			int result = 0;
			conn = DBConnectionUtil.getConnection();
			String query = "UPDATE information SET Name = ?, Date_Of_Birth = ?, Email = ?, Address = ?, Phone = ?, Content = ? WHERE Id = ?";
			try {
				pst = conn.prepareStatement(query);
				pst.setString(1, information.getName());
				pst.setString(2, information.getDate());
				pst.setString(3, information.getEmail());
				pst.setString(4, information.getDiachi());
				pst.setInt(5, information.getPhone());
				pst.setString(6, information.getContent());
				pst.setInt(7, information.getId());
				result = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
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
			String query = "DELETE FROM information WHERE Id = ?";
			try {
				pst = conn.prepareStatement(query);
				pst.setInt(1, id);
				result = pst.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
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

		public Information getItem() {
			Information listInfo = null;
			conn = DBConnectionUtil.getConnection();
			String query = "SELECT * FROM information WHERE Status = 1";
			try {
				st = conn.createStatement();
				rs = st.executeQuery(query);
				if(rs.next()){
					int id = rs.getInt("Id");
					String name = rs.getString("Name");
					String date = rs.getString("Date_Of_Birth");
					String email = rs.getString("Email");
					String diachi = rs.getString("Address");
					int phone = rs.getInt("Phone");
					String content = rs.getString("Content");
					int status = rs.getInt("Status");
					listInfo = new Information(id, name, date, email, diachi, phone, content, status);
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
			return listInfo;
		}

		public int countItems() {
			int a = 0;
			conn = DBConnectionUtil.getConnection();
			String query = "SELECT COUNT(Id) as tong FROM information";
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

		public ArrayList<Information> getItems(int offset) {
			ArrayList<Information> listInfor = new ArrayList<>();
			conn = DBConnectionUtil.getConnection();
			String query = "SELECT * FROM information ORDER BY Id DESC LIMIT ?, ?";
			try {
				pst = conn.prepareStatement(query);
				pst.setInt(1, offset);
				pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
				rs = pst.executeQuery();
				while(rs.next()){
					int id = rs.getInt("Id");
					String name = rs.getString("Name");
					String date = rs.getString("Date_Of_Birth");
					String email = rs.getString("Email");
					String diachi = rs.getString("Address");
					int phone = rs.getInt("Phone");
					String content = rs.getString("Content");
					int status = rs.getInt("Status");
					Information information = new Information(id, name, date, email, diachi, phone, content, status);
					listInfor.add(information);
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
			return listInfor;
		}
}

	
