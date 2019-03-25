package com.bit.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mysite.repository.UserDAO;
import com.bit.mysite.vo.UserVO;

@Service
public class UserService {
	@Autowired
	private UserDAO userDAO;
	
	public void join(UserVO vo) {
		userDAO.insert(vo);
	}
	
	public UserVO login(String email, String password) {
		UserVO userVO = null;
		userVO = userDAO.get(email, password);
		return userVO;
	}
	
	public UserVO getUser(Long no) {
		return userDAO.get(no);
	}
	
	public void updateUser(UserVO vo) {
		userDAO.update(vo);
	}
	
	public boolean emailExists(String email) {
		return (userDAO.get(email) != null);
	}
}
