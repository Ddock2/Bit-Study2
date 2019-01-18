package com.bit.day10.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.bit.util.FileClose;

// DAO : Data Access Object

public class UserDAO {
	ArrayList<UserVO> list = new ArrayList<>();
	
	public void process() {
		save();
		load();
	}
	
	private void save() {
		list.add(new UserVO("박신혜", 30, "서울"));
		list.add(new UserVO("이효리", 40, "제주"));
		list.add(new UserVO("박효신", 39, "서울"));
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("iotest/object_list.txt");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(list);
			System.out.println("데이터베이스(.txt)에 저장 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(fos, oos);
		}
	}
	
	@SuppressWarnings("unchecked")
	private void load() {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("iotest/object_list.txt");
			ois = new ObjectInputStream(fis);
			
			list = (ArrayList<UserVO>) ois.readObject();
			
			System.out.println("데이터베이스(.txt)에서 읽음");
			for(UserVO u : list) {
				System.out.println(u);
			}
			System.out.println();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			FileClose.close(fis, ois);
		}
	}
}
