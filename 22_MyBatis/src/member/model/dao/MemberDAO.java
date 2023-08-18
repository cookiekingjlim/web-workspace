package member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import member.model.vo.MemberVO;

public class MemberDAO{
	
	private static MemberDAO dao = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return dao;
	}
	
	/*
	 * SqlSession을 통한 쿼리 실행
	 * - insert(String mapper, Object param) : int - DB에 데이터를 입력하고자 할 때 사용
	 * - update(String mapper, Object param) : int - DB의 데이터를 수정하고자 할 때 사용
	 * - delete(String mapper, Object param) : int - DB의 데이터를 삭제하고자 할 때 사용
	 * - selectOne(String mapper, Object param) : Object - 하나의 객체만을 받고자 할 때 사용
	 * - selectList(String mapper, Object param) : List<E> - 결과에 대한 값을 List로 받고자 할 때 사용
	 * - selectMap(String mapper, Object param, String mapKey) : Map(K, V) - 결과에 대한 값을 Map으로 받고자 할 때 사용
	 * */
	
	public int registerMember(SqlSession sqlSession, MemberVO vo) {	// parameter값 있으니까 MemberVO
		return sqlSession.insert("memberMapper.registerMember", vo);	// namespace의 해당 아이디값+파라미터값 넘겨
		
	}
	
	// showAllMember, findByIdMember, login, updateMember
	public List<MemberVO> showAllMember(SqlSession sqlSession){
		return sqlSession.selectList("memberMapper.showAllMember");
	}
	
	public MemberVO findByIdMember(SqlSession sqlSession, String id) {
		return sqlSession.selectOne("memberMapper.findByIdMember", id);
		
	}
	
	public MemberVO login(SqlSession sqlSession, MemberVO vo) {
		return sqlSession.selectOne("memberMapper.login", vo);
	}
	
	public int updateMember(SqlSession sqlSession, MemberVO vo) {
		return sqlSession.update("memberMapper.login", vo);
	}
	

}
