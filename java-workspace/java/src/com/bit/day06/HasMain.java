package com.bit.day06;

public class HasMain {
	
	public static void main(String[] args) {
		Police p1 = new Police(3);
		Police p2 = new Police(0);
		
		p1.targetShut();
		p2.targetShut();
	}
	
}

// Has-A 관계 (복합관계)
class Police {
	Gun gun;
	
	public Police() { }
	
	public Police(int bullet) {
		getGun(bullet);
	}
	
	public void getGun(int bullet) {
		if(gun != null && gun.getBullet()>0)
			System.out.println("이미 총 있음");
		else
			gun = new Gun(bullet);
	}
	
	public void targetShut() {
		if(gun == null || gun.getBullet()<1) {
			System.out.println("총이 없습니다.");
		}else {
			System.out.println("총을 발사하겠습니다.");
			gun.shut();
			gun.status();
		}
	}
}

class Gun {
	private int bullet;
	
	public Gun() { }
	
	public Gun(int bullet) {
		this.bullet = bullet;
	}
	
	public void shut() {
		if(bullet>0) {
			bullet--;
			System.out.println("발사");
		}
	}
	
	public void status() {
		System.out.println("남은 총알 : " + bullet);
	}
	
	public int getBullet() {
		return bullet;
	}
}