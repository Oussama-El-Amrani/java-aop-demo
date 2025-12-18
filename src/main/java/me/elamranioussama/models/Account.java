package me.elamranioussama.models;

public class Account {
    private Long code;
    private Double balance;

    public Account(Long code, Double balance) {
        this.code = code;
        this.balance = balance;
    }

    public Long getCode() {
        return code;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
