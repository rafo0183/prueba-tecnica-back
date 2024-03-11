package com.pruebatecnica.repository;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transfers")
public class Transfer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@OneToOne
	@JoinColumn(name = "checking_account_id")
	private CheckingAccount checkingAccount;
	@Column(name = "amount")
	private Long amount;
	@Column(name = "hash")
	private String hash;
	@Column(name = "checking_account_destination")
	private Long checkingAccountDestination;
	@Column(name = "bank_destination")
	private String bankDestination;
	@Column(name = "name_destination")
	private String nameDestination;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "updated_at")
	private Date updatedAt;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CheckingAccount getCheckingAccount() {
		return checkingAccount;
	}
	public void setCheckingAccount(CheckingAccount checkingAccount) {
		this.checkingAccount = checkingAccount;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public Long getCheckingAccountDestination() {
		return checkingAccountDestination;
	}
	public void setCheckingAccountDestination(Long checkingAccountDestination) {
		this.checkingAccountDestination = checkingAccountDestination;
	}
	public String getBankDestination() {
		return bankDestination;
	}
	public void setBankDestination(String bankDestination) {
		this.bankDestination = bankDestination;
	}
	public String getNameDestination() {
		return nameDestination;
	}
	public void setNameDestination(String nameDestination) {
		this.nameDestination = nameDestination;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "Transfer [id=" + id + ", user=" + user + ", checkingAccount=" + checkingAccount + ", amount=" + amount
				+ ", hash=" + hash + ", checkingAccountDestination=" + checkingAccountDestination + ", bankDestination="
				+ bankDestination + ", nameDestination=" + nameDestination + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}	
}
