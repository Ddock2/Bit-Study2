package com.bit.util;

import java.io.File;
import java.util.UUID;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileNamePolicy implements FileRenamePolicy {

	@Override
	public File rename(File f) {
		String name = f.getName();
		String ext = "";
		int dot = name.lastIndexOf(".");
		
		// 파일 이름을 새롭게 하기위해, 확장자 존재 유무 판단
		if(dot != -1) {
			ext = name.substring(dot);
		}else {
			ext = "";
		}
		
		/*
		 	UID (User ID)
		 		: 사용자 식별자 (OS에 따라 32비트, 64비트 등...)
		 	UUID (Universally Unique Identifier)
		 		: 범용 고유 식별자 (32개의 16진수로 표현, 128비트)
		 */
		String fileName = "bit" + UUID.randomUUID();	// 유니크한 번호 생성
		File renameFile = new File(f.getParentFile(), fileName + ext);
		
		return renameFile;
	}
	
}
