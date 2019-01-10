package com.bit.day04.Prob;

// Prob5 계좌 객체

public class Account {
	private String accountNo;
	private int balance;
	
	public Account() {
		
	}
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
		balance = 0;
		System.out.println(accountNo + " 계좌가 개설 되었습니다.");
		viewBalance();
	}
	
	// 입금
	public void save(int money) {
		balance += money;
		System.out.println(accountNo + " 계좌에 " + money + "만원이 입금되었습니다.");
		viewBalance();
	}
	
	// 출금
	public void deposit(int money) {
		balance -= money;
		System.out.println(accountNo + " 계좌에 " + money + "만원이 출금되었습니다.");
		viewBalance();
	}
	
	// 잔액 확인
	public void viewBalance() {
		System.out.println(accountNo + " 계좌의 잔고는 " + balance +"만원 입니다.");
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
}
