package com.bit.day12.prob6;

public class Rectangle extends Shape implements Resizable{
	
	double width;
	double height;
	
	public Rectangle(double w, double h) {
		width = w;
		height = h;
	}

	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	@Override
	public double getPerimeter() {
		return 2*(width + height);
	}
	
}
