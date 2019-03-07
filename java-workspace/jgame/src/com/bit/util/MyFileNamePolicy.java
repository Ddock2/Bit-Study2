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
		
		if(dot != -1) {
			ext = name.substring(dot);
		}else {
			ext = "";
		}
		
		String fileName = "bit" + UUID.randomUUID();
		File renameFile = new File(f.getParentFile(), fileName + ext);
		
		return renameFile;
	}
	
}
