package com.bit.day12.prob6;

public class RectTriangle extends Shape{
	double width;
	double height;
	
	public RectTriangle(double w, double h) {
		width = w;
		height = h;
	}
	
	@Override
	public double getArea() {
		return width * height / 2;
	}


	@Override
	public double getPerimeter() {
		double result = width + height;
		result += Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
		
		return result;
	}
	
}
