package com.bit.day07;

public class DeepCopy {
	
	public static void main(String[] args) throws CloneNotSupportedException{
		MyRectangle org = new MyRectangle(2, 2, 6, 6);
		MyRectangle cpy;
		
		cpy = (MyRectangle) org.clone();
		org.setPoisition(1, 1, 9, 9);
		org.rectInfo();
		cpy.rectInfo();
	}
	
}

// 좌표
class MyPoint implements Cloneable {
	private int xPos;
	private int yPos;
	
	public MyPoint(int xPos, int yPos) {
		setPosition(xPos, yPos);
	}
	
	public void posInfo() {
		System.out.println("(" + xPos + ", " + yPos + ")");
	}
	
	public void setPosition(int xPos, int yPos) {
		this.xPos = xPos;
		this.yPos = yPos;		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

// 두 좌표를 통해 사각형의 정보
class MyRectangle implements Cloneable{
	Point point1, point2;

	public MyRectangle(int xPos1, int yPos1, int xPos2, int yPos2) {
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
	
	// Deep Copy (깊은 복사)
	//	MyRectangle과 MyPoint객체
	//	MyRectangle객체 내부에 MyPoint 포함
	//	-> MyRectangle을 복제하자니 얕은 복사
	//	-> 껍데기인 MyRectangle을 복제할 때,
	//		알맹이인 Point1, Point2도 복제
	@Override
	public Object clone() throws CloneNotSupportedException{
		// 얕은 복사
//		return super.clone();
		MyRectangle cpy = (MyRectangle)super.clone();
		cpy.point1 = (Point)point1.clone();
		cpy.point2 = (Point)point2.clone();
		return cpy;
	}
}