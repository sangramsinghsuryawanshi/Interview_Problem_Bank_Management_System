package com.project.B.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BankAccount 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int acountId;
	private String accountHolderName;
	private double balance;
	public int getAcountId() {
		return acountId;
	}
	public void setAcountId(int acountId) {
		this.acountId = acountId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "BankAccount [acountId=" + acountId + ", accountHolderName=" + accountHolderName + ", balance=" + balance
				+ "]";
	}
	public BankAccount(int acountId, String accountHolderName, double balance) {
		super();
		this.acountId = acountId;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
	}
	public BankAccount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
