package com.pruebatecnica.model.request;

import com.pruebatecnica.repository.User;

public class TransferInformation {
	String nameDestination;
	String bankDestination;
	Long checkingAccountDestination;
	Long amount;
	User userId;
	String checkingAccount;
	
	public String getNameDestination() {
		return nameDestination;
	}
	public void setNameDestination(String nameDestination) {
		this.nameDestination = nameDestination;
	}
	public String getBankDestination() {
		return bankDestination;
	}
	public void setBankDestination(String bankDestination) {
		this.bankDestination = bankDestination;
	}
	public Long getCheckingAccountDestination() {
		return checkingAccountDestination;
	}
	public void setCheckingAccountDestination(Long checkingAccountDestination) {
		this.checkingAccountDestination = checkingAccountDestination;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	public String getCheckingAccount() {
		return checkingAccount;
	}
	public void setCheckingAccount(String checkingAccount) {
		this.checkingAccount = checkingAccount;
	}
}
