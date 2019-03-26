package com.bit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bit.domain.User;

@Service
public class UserService {
	public List<User> getAllUsers(){
		List<User> list = new ArrayList<User>();
		
		User user = new User();
		user.setId(1L);
		user.setName("노준");
		user.setPhone("010-4103-1442");
		user.setEmail("realfunlady@gmail.com");
		user.setProfilePic("...");
		user.setStatus(1);
		list.add(user);
		
		user = new User();
		user.setId(2L);
		user.setName("박수현");
		user.setPhone("010-5103-1442");
		user.setEmail("real@gmail.com");
		user.setProfilePic("...");
		user.setStatus(1);
		list.add(user);
		
		user = new User();
		user.setId(3L);
		user.setName("커퓌");
		user.setPhone("010-1103-1442");
		user.setEmail("reawe@gmail.com");
		user.setProfilePic("...");
		user.setStatus(1);
		list.add(user);
		
		user = new User();
		user.setId(4L);
		user.setName("피카츄");
		user.setPhone("010-4123-2332");
		user.setEmail("elec@naver.com");
		user.setProfilePic("...");
		user.setStatus(1);
		list.add(user);
		
		user = new User();
		user.setId(5L);
		user.setName("아이작");
		user.setPhone("010-0323-3682");
		user.setEmail("bind@daum.net");
		user.setProfilePic("...");
		user.setStatus(1);
		list.add(user);
		
		user = new User();
		user.setId(6L);
		user.setName("딸기");
		user.setPhone("010-5734-1564");
		user.setEmail("stbe@naver.com");
		user.setProfilePic("...");
		user.setStatus(1);
		list.add(user);
		
		user = new User();
		user.setId(7L);
		user.setName("한계임");
		user.setPhone("010-3902-6434");
		user.setEmail("limit@daum.net");
		user.setProfilePic("...");
		user.setStatus(1);
		list.add(user);
		
		return list;
	}
}
