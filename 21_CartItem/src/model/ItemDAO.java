package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;

public class ItemDAO implements ItemDAOTemplate{

	private static ItemDAO dao = new ItemDAO();
	private ItemDAO() {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
		} catch (ClassNotFoundException e) {}
	}
	public static ItemDAO getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		closeAll(ps, conn);
	}

	@Override
	public ArrayList<Item> getAllItem() throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM item";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ResultSet rs = ps.executeQuery();
		ArrayList<Item> list = new ArrayList();
		while(rs.next()) {
			list.add(new Item(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
		}
		closeAll(rs,ps,conn);
		return list;
	}

	@Override
	public Item getItem(int itemId) throws SQLException {
		Connection conn = getConnection();
		
		String query = "SELECT * FROM item WHERE item_id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, itemId);
		
		ResultSet rs = ps.executeQuery();
		
		Item item = null;
		if(rs.next()) {
			item = new Item(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getInt(6));
			
//			item.setItemId(rs.getInt("itemId"));
//			item.setItemName(rs.getString("itemName"));
//			item.setPrice(rs.getInt("price"));
//			item.setPictureUrl(rs.getString("pictureUrl"));
//			item.setDescription(rs.getString("desc"));
//			item.setCount(rs.getInt("count"));
			
		}
		
		closeAll(rs,ps,conn);
		return item;
	}

	@Override
	public boolean updateRecordCount(int itemId) throws SQLException {
		Connection conn = getConnection();
		
		String query = "UPDATE item SET count=count+1 WHERE item_id=?";
		PreparedStatement ps = conn.prepareStatement(query);
		
//		int count = getItem(itemId).getCount();
		
//		ps.setInt(1, ++count);
		ps.setInt(1, itemId);
		
		int row = ps.executeUpdate();		// 결과값이 0 아니면 1이니까 int로 넘겨
		boolean result = false;
		if(row > 0 ) result = true;
			return true;
		
	}

	public static void maia(String[] args) {
		
	}
}
