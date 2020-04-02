package model.entities;

import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public String getHolder() {
		return holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	public void deposit(Double amount) {
		balance += amount;
	}
	
	public void withdraw(Double amount) throws DomainException {
		if ( withdrawLimit > 0 ) {
			
			if ( (withdrawLimit + balance) < amount) {
				throw new DomainException("Your Balance and Withdraw Limit available are not enough to do this operation");
			}
				
		} else {
			
			if (balance < amount) {
				throw new DomainException("Your Balance is not enought to do this operation");
			}
			
		}
	}

	
	
}
