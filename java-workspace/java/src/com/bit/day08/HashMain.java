package com.bit.day08;

import java.util.HashSet;

public class HashMain {
	
	public static void main(String[] args) {
		HashSet<HashItem> hSet = new HashSet<>();
//		hSet.add(new HashItem(1000, "AAA"));
//		hSet.add(new HashItem(1001, "BBB"));
//		hSet.add(new HashItem(1002, "CCC"));
//		hSet.add(new HashItem(1003, "DDD"));
//		hSet.add(new HashItem(1004, "EEE"));
//		hSet.add(new HashItem(1005, "FFF"));
		
		for(int i=1; i<1000; i++) {
			hSet.add(new HashItem(i*100, "name"));
		}
		
		for(HashItem item : hSet) {
			System.out.println(item);
		}
	}
	
}

class HashItem {
	private int id;
	private String name;
	
	public HashItem(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		HashItem temp = (HashItem)obj;
		return id == temp.id;
	}
	
	@Override
	public int hashCode() {
		return id % 3;
	}
	
	@Override
	public String toString() {
		return "HashItem [id=" + id
				+ ", name=" + name
				+ ", hashCode=" + id%3 + "]";
	}
}