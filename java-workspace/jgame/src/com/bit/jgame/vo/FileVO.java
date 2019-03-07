package com.bit.jgame.vo;

/*
 	CREATE TABLE jgame_profile_img(
	    id                      VARCHAR2(20)    PRIMARY KEY,
	    profile_img_save_name   VARCHAR2(200)   NOT NULL,
	    profile_img_ori_name    VARCHAR2(200)   NOT NULL,
	    CONSTRAINT jgame_profile_img_id_fk
	        FOREIGN KEY(id)
	        REFERENCES jgame_member(id)
	        ON DELETE CASCADE
	);
 */

public class FileVO {
	private String id;
	private String file_ori_name;
	private String file_save_name;
	
	public FileVO() {
		super();
	}

	public FileVO(String id, String file_ori_name, String file_save_name) {
		super();
		this.id = id;
		this.file_ori_name = file_ori_name;
		this.file_save_name = file_save_name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFile_ori_name() {
		return file_ori_name;
	}
	public void setFile_ori_name(String file_ori_name) {
		this.file_ori_name = file_ori_name;
	}
	public String getFile_save_name() {
		return file_save_name;
	}
	public void setFile_save_name(String file_save_name) {
		this.file_save_name = file_save_name;
	}

	@Override
	public String toString() {
		return "FileVO [id=" + id + ", file_ori_name=" + file_ori_name + ", file_save_name=" + file_save_name + "]";
	}
	
}
