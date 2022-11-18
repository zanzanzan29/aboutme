package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.DBConnectionUtil;
import util.DefineUtil;
import model.bean.Contact;

public class ContactDAO {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ArrayList<Contact> getItems() {
		ArrayList<Contact> listContact = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM contact ORDER BY Id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				String diachi = rs.getString("Address");
				int phone = rs.getInt("Phone");
				String noidung = rs.getString("Content");
				Contact contact = new Contact(id, name, email, diachi, phone, noidung);
				listContact.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs!= null && st!= null && conn != null){
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
		return listContact;
	}

	public int addItem(Contact contact) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO contact(Name,Email,Address,Phone,Content) VALUES (?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, contact.getName());
			pst.setString(2, contact.getEmail());
			pst.setString(3, contact.getDiachi());
			pst.setInt(4, contact.getPhone());
			pst.setString(5, contact.getNoidung());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(pst!= null && conn != null){
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
		String query = "DELETE FROM contact WHERE Id = ?";
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
		String query = "SELECT COUNT(Id) as tong FROM contact";
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

	public ArrayList<Contact> getItems(int offset) {
		ArrayList<Contact> listContact = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT * FROM contact ORDER BY Id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("Id");
				String name = rs.getString("Name");
				String email = rs.getString("Email");
				String diachi = rs.getString("Address");
				int phone = rs.getInt("Phone");
				String noidung = rs.getString("Content");
				Contact contact = new Contact(id, name, email, diachi, phone, noidung);
				listContact.add(contact);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs!= null && pst!= null && conn != null){
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
		return listContact;
	}
	
}
