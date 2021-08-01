package order.entity;

import java.util.Date;

/**
 * 功能描述：菜品类(菜品id，菜品名，菜品类型(面食、 米饭 、火锅、粤菜…)，上架时间，单价，月销售，总数量)
 *
 */
public class Dishes {
    private String id;
    private String name;
    private String type;
    private Date time;
    private double price;
    private int sales;
    private int stocks;

    public Dishes(String id, String name, String type, Date time, double price, int sales, int stocks) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.time = time;
        this.price = price;
        this.sales = sales;
        this.stocks = stocks;
    }

    public Dishes() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStocks() {
        return stocks;
    }

    public void setStocks(int stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Dishes{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", price=" + price +
                ", sales=" + sales +
                ", stocks=" + stocks +
                '}';
    }
}
