package com.bit2015.mysite.vo;

import java.util.ArrayList;
import java.util.List;

import com.bit2015.mysite.dao.UserVO;

public class UserDAO {
	static List<UserVO> list = new ArrayList<>();
	
	public void signUp(UserVO vo) {
		String id = vo.getId();
		int i = 0;
		
		for(UserVO u : list) {
			i++;
			if(u.getId().equals(id)) {
				break;
			}
			if(i == list.size()) {
				list.add(vo);
			}
		}
	}
	
}
