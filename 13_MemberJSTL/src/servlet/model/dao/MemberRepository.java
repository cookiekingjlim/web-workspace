package servlet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import servlet.model.vo.MemberDTO;

/*
 * Override => 상속 받은 클래스 재정의
 * Overloading => 메소드 중첩,,,?
 * */

public class MemberRepository implements MemberDAOTemplate{

		@Override
		public Connection getConnection() throws SQLException {
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			return conn;
		}

		@Override
		public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
			ps.close();
			conn.close();
		}

		@Override
		public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
			rs.close();
			closeAll(ps,conn);
		}

		@Override
		public void registerMember(MemberDTO dto) throws SQLException {
			Connection conn = getConnection();
			
			String query = "INSERT INTO member(id,password,name,address) VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getAddress());
			
			ps.executeUpdate();
			
			closeAll(ps, conn);
		}

		@Override
		public MemberDTO login(String id, String password) throws SQLException {
			Connection conn = getConnection();
			
			String query = "SELECT * FROM member WHERE id=? AND password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			MemberDTO dto = null;
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				
			}
			
			closeAll(rs ,ps, conn);
			return dto;
		}

		@Override
		public MemberDTO findByIdMember(String id) throws SQLException {
			Connection conn = getConnection();
			
			String query = "SELECT * FROM member WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			MemberDTO dto = null;
			if(rs.next()) {
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
			}
			closeAll(rs, ps, conn);
			return dto;
		}

		@Override
		public ArrayList<MemberDTO> showAllMember() throws SQLException {
			Connection conn = getConnection();
			
			String query = "SELECT * FROM member";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			ArrayList<MemberDTO> list = new ArrayList();
			while(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getString("password"));
				dto.setName(rs.getString("name"));
				dto.setAddress(rs.getString("address"));
				
				list.add(dto);
			}
			
			closeAll(rs, ps, conn);
			return list;
		}
		
		@Override
		public void updateMember(MemberDTO dto) throws SQLException {
			Connection conn = getConnection();
			
			System.out.println("update :: " + dto.getAddress());
			
			String query = "UPDATE member SET password=?, name=?, address=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement("UPDATE member SET password=?, name=?, address=? WHERE id=?");
			
			ps.setString(1, dto.getPassword());
			ps.setString(2, dto.getName());
			ps.setString(3, dto.getAddress());
			ps.setString(4, dto.getId());
			
			System.out.println(ps.executeUpdate() + "명 변경!");
		
			closeAll(ps,conn);

		}
	}


