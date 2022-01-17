package com.revature.projects.RevatureBankAPI.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Column(name = "cust_id")
    private Long custId;

    @Column(name = "balance")
    private double balance;

    @Column(name = "opening_date")
    private Date dateOfOpening;

    @Column(name = "status")
    private boolean status;

    public Account() {
        super();
    }

    public Account(Long accountId, Long custId, double balance, Date dateOfOpening, boolean status) {
        this.accountId = accountId;
        this.custId = custId;
        this.balance = balance;
        this.dateOfOpening = dateOfOpening;
        this.status = status;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(Date dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account [accountId=" + accountId + ", custId=" + custId + ", balance=" + balance + ", dateOfOpening="
                + dateOfOpening + ", status=" + status + "]";
    }

}