package model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.vo.StudentVO;

public class StudentDAO {
	
	private static StudentDAO dao = new StudentDAO();
	private StudentDAO() {}
	public static StudentDAO getInstance() {
		return dao;
	}
	
	public List<StudentVO> showStudent(SqlSession sqlSession, String word){
		return sqlSession.selectList("studentMapper.showStudent", word);
	}
}
