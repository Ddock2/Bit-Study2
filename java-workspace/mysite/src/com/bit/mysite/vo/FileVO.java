package com.bit.mysite.vo;

/*
 	CREATE TABLE mysite_board_file (
 		no				NUMBER(6)		PRIMARY KEY,
 		board_no		NUMBER(6)		NOT NULL,
 		file_ori_name	VARCHAR2(200)	NOT NULL,
 		file_save_name	VARCHAR2(200)	NOT NULL,
 		file_size		NUMBER(6)		NOT NULL
 	);
 	
 	CREATE SEQUENCE seq_mysite_board_file_no;
 */

public class FileVO {
	private int no;
	private int board_no;
	private String file_ori_name;
	private String file_save_name;
	private int file_size;
	
	public FileVO() {
		super();
	}
	
	public FileVO(int board_no, String file_ori_name, String file_save_name, int file_size) {
		super();
		this.board_no = board_no;
		this.file_ori_name = file_ori_name;
		this.file_save_name = file_save_name;
		this.file_size = file_size;
	}

	public FileVO(int no, int board_no, String file_ori_name, String file_save_name, int file_size) {
		super();
		this.no = no;
		this.board_no = board_no;
		this.file_ori_name = file_ori_name;
		this.file_save_name = file_save_name;
		this.file_size = file_size;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
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
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	
	@Override
	public String toString() {
		return "FileVO [no=" + no + ", board_no=" + board_no + ", file_ori_name=" + file_ori_name + ", file_save_name="
				+ file_save_name + ", file_size=" + file_size + "]";
	}
	
}
