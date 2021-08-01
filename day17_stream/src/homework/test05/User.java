package homework.test05;

import java.util.ArrayList;

/**
 *
 */
public class User implements Comparable{
    private String userID;
    private boolean isVip;
    private int balance;

    public User(String userID, boolean isVip, int balance) {
        this.userID = userID;
        this.isVip = isVip;
        this.balance = balance;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +"userID='" + userID + '\'' +", isVip=" + isVip +", balance=" + balance +'}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

