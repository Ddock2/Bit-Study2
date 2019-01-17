package com.bit.util;

public class ArrayUtil {
	// double[] -> int[]
	public static int[] doubleToInt(double[] dArr) {
		if(dArr == null) {
			return null;
		}
		
		int length = dArr.length;
		int[] result = new int[length];
		
		for(int i=0; i<length; i++) {
			result[i] = (int)dArr[i];
		}
		
		return result;
	}
	
	// int[] -> double[]
	public static double[] intToDouble(int[] iArr) {
		if(iArr == null) {
			return null;
		}
		int length = iArr.length;
		double[] result = new double[length];
		
		for(int i=0; i<length; i++) {
			result[i] = iArr[i];
		}
		
		return result;
	}
	
	public static int[] concat(int[] a, int[] b) {
		int aLength = (a == null) ? 0 : a.length;
		int bLength = (b == null) ? 0 : b.length;
		
		int length = aLength + bLength;
		int[] result = new int[length];
		
		for(int i=0; i<aLength; i++) {
			result[i] = a[i];
		}
		for(int i=0; i<bLength; i++) {
			result[i+aLength] = b[i];
		}
		
		return result;
	}
}
