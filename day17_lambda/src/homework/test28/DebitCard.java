package homework.test28;

/**
 * 借记卡
 */
public class DebitCard {
    private String accountNumber;
    private int money;

    public DebitCard() {
    }

    public DebitCard(String accountNumber, int money) throws MoneyException {
        if(money < 0){
            throw new MoneyException("余额为负数！");
        }else{
            this.accountNumber = accountNumber;
            this.money = money;
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) throws MoneyException {
        if(money < 0){
            throw new MoneyException("余额为负数！");
        }else{
            this.money = money;
        }
    }

    @Override
    public String toString() {
        return "DebitCard{" +
                "accountNumber='" + accountNumber + '\'' +
                ", money=" + money +
                '}';
    }
}
