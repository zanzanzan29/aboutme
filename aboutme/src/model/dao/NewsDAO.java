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

public class NewsDAO {
	private Connection conn;
	private PreparedStatement pst;
	private Statement st;
	private ResultSet rs;
	
	public ArrayList<News> getItems() {
		ArrayList<News> listNews = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT n.Id AS nid, n.Name AS nname, c.Name As cname, c.Id AS cid, Picture , Status, MoTa, ChiTiet, View , Nguoiviet "
				+ "FROM news AS n "
				+ "INNER JOIN categories AS c "
				+ "ON n.Id_Cat = c.Id "
				+ "ORDER BY n.Id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("nid");
				String name = rs.getString("nname");
				Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
				String picture = rs.getString("Picture");
				int status = rs.getInt("Status");
				String mota = rs.getString("MoTa");
				String ChiTiet = rs.getString("ChiTiet");
				int view = rs.getInt("View");
				String nguoiviet = rs.getString("Nguoiviet");
				News items = new News(id, name, category, picture, status,mota,ChiTiet,view,nguoiviet);
				listNews.add(items);
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
		return listNews;
	}

	public int TrangThai(int nid, int trangthai) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "UPDATE news SET Status = ? WHERE Id = ? ";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, trangthai);
			pst.setInt(2, nid);
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

	public int addItem(News news) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "INSERT INTO news(Name,Id_Cat,Picture,MoTa,ChiTiet,Nguoiviet) VALUES (?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, news.getName());
			pst.setInt(2, news.getCategory().getId());
			pst.setString(3, news.getPicture());
			pst.setString(4, news.getMota());
			pst.setString(5, news.getChitiet());
			pst.setString(6, news.getNguoiviet());
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

	public News getItem(int id) {
		News item = null;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT n.Id AS nid, n.Name AS nname, c.Name As cname, c.Id AS cid, Picture , Status, MoTa, ChiTiet, View ,Nguoiviet "
				+ "FROM news AS n "
				+ "INNER JOIN categories AS c "
				+ "ON n.Id_Cat = c.Id "
				+ "WHERE n.Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				int nid = rs.getInt("nid");
				String name = rs.getString("nname");
				Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
				String picture = rs.getString("Picture");
				int status = rs.getInt("Status");
				String mota = rs.getString("MoTa");
				String ChiTiet = rs.getString("ChiTiet");
				int view = rs.getInt("View");
				String nguoiviet = rs.getString("Nguoiviet");
				item = new News(nid, name, category, picture, status,mota,ChiTiet,view,nguoiviet);
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

	public int editItem(News news) {
		int result = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "UPDATE news SET Name = ? ,Id_Cat = ?,Picture = ?,MoTa = ?,ChiTiet = ? WHERE Id = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, news.getName());
			pst.setInt(2, news.getCategory().getId());
			pst.setString(3, news.getPicture());
			pst.setString(4, news.getMota());
			pst.setString(5, news.getChitiet());
			pst.setInt(6, news.getId());
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
		String query = "DELETE FROM news WHERE Id = ?";
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

	public ArrayList<News> getItemsTT() {
		ArrayList<News> listNews = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT n.Id AS nid, n.Name AS nname, c.Name As cname, c.Id AS cid, Picture , Status, MoTa, ChiTiet, View, Nguoiviet "
				+ "FROM news AS n "
				+ "INNER JOIN categories AS c "
				+ "ON n.Id_Cat = c.Id "
				+ "WHERE Status = 1 "
				+ "ORDER BY n.Id DESC";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("nid");
				String name = rs.getString("nname");
				Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
				String picture = rs.getString("Picture");
				int status = rs.getInt("Status");
				String mota = rs.getString("MoTa");
				String ChiTiet = rs.getString("ChiTiet");
				int view = rs.getInt("View");
				String nguoiviet = rs.getString("Nguoiviet");
				News items = new News(id, name, category, picture, status,mota,ChiTiet,view,nguoiviet);
				listNews.add(items);
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
		return listNews;
	}

	public ArrayList<News> getItemsXemNhieu() {
		ArrayList<News> listNews = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT n.Id AS nid, n.Name AS nname, c.Name As cname, c.Id AS cid, Picture , Status, MoTa, ChiTiet, View, Nguoiviet "
				+ "FROM news AS n "
				+ "INNER JOIN categories AS c "
				+ "ON n.Id_Cat = c.Id "
				+ "WHERE Status = 1 "
				+ "ORDER BY View DESC LIMIT 0, 3";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			while(rs.next()){
				int id = rs.getInt("nid");
				String name = rs.getString("nname");
				Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
				String picture = rs.getString("Picture");
				int status = rs.getInt("Status");
				String mota = rs.getString("MoTa");
				String ChiTiet = rs.getString("ChiTiet");
				int view = rs.getInt("View");
				String nguoiviet = rs.getString("Nguoiviet");
				News items = new News(id, name, category, picture, status,mota,ChiTiet,view,nguoiviet);
				listNews.add(items);
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
		return listNews;
	}

	public ArrayList<News> getItems(int cid) {
		ArrayList<News> listNews = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT n.Id AS nid, n.Name AS nname, c.Name As cname, c.Id AS cid, Picture , Status, MoTa, ChiTiet, View, Nguoiviet "
				+ "FROM news AS n "
				+ "INNER JOIN categories AS c "
				+ "ON n.Id_Cat = c.Id "
				+ "WHERE Status = 1 AND c.Id = ? "
				+ "ORDER BY n.Id DESC";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, cid);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("nid");
				String name = rs.getString("nname");
				Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
				String picture = rs.getString("Picture");
				int status = rs.getInt("Status");
				String mota = rs.getString("MoTa");
				String ChiTiet = rs.getString("ChiTiet");
				int view = rs.getInt("View");
				String nguoiviet = rs.getString("Nguoiviet");
				News items = new News(id, name, category, picture, status,mota,ChiTiet,view,nguoiviet);
				listNews.add(items);
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
		return listNews;
	}

	public void increaseView(int id) {
		conn = DBConnectionUtil.getConnection();
		
		String query = "UPDATE news SET View = View + 1 WHERE id = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(pst != null && conn != null){
				try {
					pst.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public int getTT0(){
		int i = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(Id) AS i FROM news WHERE Status = 0";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(query);
			if(rs.next()){
				i = rs.getInt("i");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(rs != null && st != null && conn != null ){
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
		return i;
	}

	public int countItems() {
		int a = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(Id) as tong FROM news";
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

	public ArrayList<News> getItemslist(int offset) {
		ArrayList<News> listNews = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT n.Id AS nid, n.Name AS nname, c.Name As cname, c.Id AS cid, Picture , Status, MoTa, ChiTiet, View , Nguoiviet "
				+ "FROM news AS n "
				+ "INNER JOIN categories AS c "
				+ "ON n.Id_Cat = c.Id "
				+ "ORDER BY n.Id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("nid");
				String name = rs.getString("nname");
				Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
				String picture = rs.getString("Picture");
				int status = rs.getInt("Status");
				String mota = rs.getString("MoTa");
				String ChiTiet = rs.getString("ChiTiet");
				int view = rs.getInt("View");
				String nguoiviet = rs.getString("Nguoiviet");
				News items = new News(id, name, category, picture, status,mota,ChiTiet,view,nguoiviet);
				listNews.add(items);
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
		return listNews;
	}

	public int countItemsTT() {
		int a = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(Id) as tong FROM news WHERE Status = 1";
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

	public ArrayList<News> getItemsTT(int offset) {
		ArrayList<News> listNews = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT n.Id AS nid, n.Name AS nname, c.Name As cname, c.Id AS cid, Picture , Status, MoTa, ChiTiet, View, Nguoiviet "
				+ "FROM news AS n "
				+ "INNER JOIN categories AS c "
				+ "ON n.Id_Cat = c.Id "
				+ "WHERE Status = 1 "
				+ "ORDER BY n.Id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, offset);
			pst.setInt(2, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("nid");
				String name = rs.getString("nname");
				Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
				String picture = rs.getString("Picture");
				int status = rs.getInt("Status");
				String mota = rs.getString("MoTa");
				String ChiTiet = rs.getString("ChiTiet");
				int view = rs.getInt("View");
				String nguoiviet = rs.getString("Nguoiviet");
				News items = new News(id, name, category, picture, status,mota,ChiTiet,view,nguoiviet);
				listNews.add(items);
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
		return listNews;
	}

	public int countItems(int id) {
		int a = 0;
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT COUNT(Id) as tong FROM news WHERE Id_Cat = ? AND Status = 1";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			if(rs.next()){
				a = rs.getInt("tong");
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
		return a;
	}

	public ArrayList<News> getItems(int cid, int offset) {
		ArrayList<News> listNews = new ArrayList<>();
		conn = DBConnectionUtil.getConnection();
		String query = "SELECT n.Id AS nid, n.Name AS nname, c.Name As cname, c.Id AS cid, Picture , Status, MoTa, ChiTiet, View, Nguoiviet "
				+ "FROM news AS n "
				+ "INNER JOIN categories AS c "
				+ "ON n.Id_Cat = c.Id "
				+ "WHERE Status = 1 AND c.Id = ? "
				+ "ORDER BY n.Id DESC LIMIT ?, ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, cid);
			pst.setInt(2, offset);
			pst.setInt(3, DefineUtil.NUMBER_PER_PAGE);
			rs = pst.executeQuery();
			while(rs.next()){
				int id = rs.getInt("nid");
				String name = rs.getString("nname");
				Category category = new Category(rs.getInt("cid"), rs.getString("cname"));
				String picture = rs.getString("Picture");
				int status = rs.getInt("Status");
				String mota = rs.getString("MoTa");
				String ChiTiet = rs.getString("ChiTiet");
				int view = rs.getInt("View");
				String nguoiviet = rs.getString("Nguoiviet");
				News items = new News(id, name, category, picture, status,mota,ChiTiet,view,nguoiviet);
				listNews.add(items);
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
		return listNews;
	}
	
}
