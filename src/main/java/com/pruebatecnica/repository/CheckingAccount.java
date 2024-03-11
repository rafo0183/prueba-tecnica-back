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
@Table(name = "checking_accounts")
public class CheckingAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;
	@Column(name = "account_number")
	private Long accountNumber;
	@Column(name = "account_balance")
	private Long accountBalance;
	@Column(name = "account_overdraft")
	private Long accountOverdraft;
	@Column(name = "reward_points")
	private Long rewardPoints;
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
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Long getAccountOverdraft() {
		return accountOverdraft;
	}
	public void setAccountOverdraft(Long accountOverdraft) {
		this.accountOverdraft = accountOverdraft;
	}
	public Long getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Long rewardPoints) {
		this.rewardPoints = rewardPoints;
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
		return "CheckingAccount [id=" + id + ", user=" + user + ", accountBalance=" + accountBalance
				+ ", accountOverdraft=" + accountOverdraft + ", rewardPoints=" + rewardPoints + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
