package com.bit.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.exception.UserDAOException;
import com.bit.mysite.vo.UserVO;

/*
 	@Repository
 		: DAO(Data Access Object)에서 발생하는 예외를
 		    스프링의 DataAccessException으로 처리하겠다.
 */

@Repository
public class UserDAO {
	@Autowired
	private SqlSession sqlSession;
	
	// 인증(로그인)
	public UserVO get(String email, String password) throws UserDAOException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("email", email);
		map.put("password", password);
		
		return sqlSession.selectOne("user.getByEmailAndPassword", map);
	}
	
	// 이메일 체크
	public UserVO get(String email) {
		return sqlSession.selectOne("user.getByEmail", email);
	}
	
	// 사용자 가져오기
	public UserVO get(Long no) {
		return sqlSession.selectOne("user.getByNo", no);
	}
	
	public void insert(UserVO vo) {
		sqlSession.insert("user.insert", vo);
	}
	
	public void update(UserVO vo) {
		sqlSession.update("user.update", vo);
	}
}
