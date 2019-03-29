package com.bit.mysite.vo;

public class GalleryVO {
	private Long no;
	private String orgFileName;
	private String saveFileName;
	private String comments;
	private String fileExtName;
	private Long fileSize;
	private String regDate;
	private Long userNo;
	private String userName;
	
	public GalleryVO() {
		super();
	}
	public GalleryVO(Long no, String orgFileName, String saveFileName, String comments, String fileExtName,
			Long fileSize, String regDate, Long userNo, String userName) {
		super();
		this.no = no;
		this.orgFileName = orgFileName;
		this.saveFileName = saveFileName;
		this.comments = comments;
		this.fileExtName = fileExtName;
		this.fileSize = fileSize;
		this.regDate = regDate;
		this.userNo = userNo;
		this.userName = userName;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getSaveFileName() {
		return saveFileName;
	}
	public void setSaveFileName(String saveFileName) {
		this.saveFileName = saveFileName;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getFileExtName() {
		return fileExtName;
	}
	public void setFileExtName(String fileExtName) {
		this.fileExtName = fileExtName;
	}
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public Long getUserNo() {
		return userNo;
	}
	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString() {
		return "GalleryVO [no=" + no + ", orgFileName=" + orgFileName + ", saveFileName=" + saveFileName + ", comments="
				+ comments + ", fileExtName=" + fileExtName + ", fileSize=" + fileSize + ", regDate=" + regDate
				+ ", userNo=" + userNo + ", userName=" + userName + "]";
	}
	
}
