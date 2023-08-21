package model.service;

import java.util.List;

import model.dao.StudentDAO;
import model.vo.StudentVO;

public class StudentService {
	
	public List<StudentVO> showStudent(String word){
		List<StudentVO> list = new StudentDAO().showStudent(sqlSession, word);
		return list;
		
	}

}
