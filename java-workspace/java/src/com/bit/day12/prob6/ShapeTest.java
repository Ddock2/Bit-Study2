package com.bit.day12.prob6;

import java.util.ArrayList;

public class ShapeTest {
	
	public static void main(String[] args) {
		Rectangle rect = new Rectangle(5, 6);
		RectTriangle rectTri = new RectTriangle(6, 2);
		
		ArrayList<Shape> list = new ArrayList<>();
		list.add(rect);
		list.add(rectTri);
		
		for(Shape s : list) {
			System.out.println("area : " + s.getArea());
			System.out.println("perimeter : " + s.getPerimeter());

			if(s instanceof Rectangle) {
				((Rectangle) s).resize(0.5);
				System.out.println("new area : " + s.getArea());
				System.out.println("new perimeter : " + s.getPerimeter());
			}
			System.out.println();
		}
	}
	
}
