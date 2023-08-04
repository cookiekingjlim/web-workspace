package servlet.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface MemberDAOTemplate {
	
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	void insertMember(MemberVO vo) throws SQLException; 
	ArrayList<MemberVO> showAllMember() throws SQLException;
	MemberVO findByNameMember(String name) throws SQLException;
	
	
}
