package servlet.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import servlet.model.vo.MemberDTO;

public interface MemberDAOTemplate {
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	void registerMember(MemberDTO dto) throws SQLException;
	MemberDTO login(String id, String password) throws SQLException;
	MemberDTO findByIdMember(String id) throws SQLException;
	ArrayList<MemberDTO> showAllMember() throws SQLException;
	void updateMember(MemberDTO dto) throws SQLException;
}
