package order.entity;

import java.util.Date;

/*
 *
 * 订单类(订单号，订单创建时间，菜品id，购买数，客户id，总价格，订单状态)
 * */
public class Order {

    private String orderId;
    private Date time;
    private Dishes dishes;//菜品
    private int number;//购买数量
    private String uid;//用户id
    private double orderPrice;//订单总价
    private int orderStatue;//订单状态

    public Order() {
    }

    public Order(String orderId, Date time, Dishes dishes, int number, String uid, double orderPrice, int orderStatue) {
        this.orderId = orderId;
        this.time = time;
        this.dishes = dishes;
        this.number = number;
        this.uid = uid;
        this.orderPrice = orderPrice;
        this.orderStatue = orderStatue;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", time=" + time +
                ", dishes=" + dishes +
                ", number=" + number +
                ", uid='" + uid + '\'' +
                ", orderPrice=" + orderPrice +
                ", orderStatue=" + orderStatue +
                '}';
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getOrderStatue() {
        return orderStatue;
    }

    public void setOrderStatue(int orderStatue) {
        this.orderStatue = orderStatue;
    }
}
