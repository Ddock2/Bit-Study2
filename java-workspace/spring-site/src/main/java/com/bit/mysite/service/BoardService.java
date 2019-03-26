package com.bit.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mysite.repository.BoardDAO;

@Service
public class BoardService {
	@Autowired
	private BoardDAO boardDAO;
}
