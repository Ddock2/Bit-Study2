package com.bit.day07;

public class ShallowCopy {
	
	public static void main(String[] args) throws CloneNotSupportedException{
		Rectangle org = new Rectangle(2, 2, 6, 6);
		Rectangle cpy;
		
		cpy = (Rectangle) org.clone();
		org.setPoisition(1, 1, 9, 9);
		org.rectInfo();
		cpy.rectInfo();
	}
	
}

// 좌표
class Point implements Cloneable {
	private int xPos;
	private int yPos;
	
	public Point(int xPos, int yPos) {
		setPosition(xPos, yPos);
	}
	
	public void posInfo() {
		System.out.println("(" + xPos + ", " + yPos + ")");
	}
	
	public void setPosition(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;		
	}
	
	// Shallow Copy (얕은 복사)
	//	Rectangle과 Point객체
	//	Rectangle객체 내부에 Point객체 포함
	//	-> 껍데기인 Rectangle만 복제
	//	-> 알맹이 Point1, Point2는 그대로
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

// 두 좌표를 통해 사각형의 정보
class Rectangle implements Cloneable{
	Point point1, point2;

	public Rectangle(int xPos1, int yPos1, int xPos2, int yPos2) {
		this.point1 = new Point(xPos1, yPos1);
		this.point2 = new Point(xPos2, yPos2);
	}
	
	public void rectInfo() {
		System.out.println("[직사각형의 위치 정보]");
		System.out.print("POINT1 : ");
		point1.posInfo();
		System.out.print("POINT2 : ");
		point2.posInfo();
	}
	
	public void setPoisition(int xPos1, int yPos1, int xPos2, int yPos2) {
		point1.setPosition(xPos1, yPos1);
		point2.setPosition(xPos2, yPos2);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}