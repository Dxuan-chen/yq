package homework.test28;

/**
 * 余额负数异常
 */
public class MoneyException extends Exception {
    public MoneyException() {
    }

    public MoneyException(String message) {
        super(message);
    }
}
