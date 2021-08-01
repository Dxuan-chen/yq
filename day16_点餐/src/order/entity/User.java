package order.entity;

import java.util.Date;

/**
 * 功能描述：客户类(客户id，客户名，性别，密码，送餐地址，手机号，创建时间)
 */
public class User {
    private String id;
    private String userName;
    private String sex;
    private String password;
    private String address;
    private String phone;
    private Date time;

    public User(String id, String userName, String sex, String password, String address, String phone, Date time) {
        this.id = id;
        this.userName = userName;
        this.sex = sex;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.time = time;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", time=" + time +
                '}';
    }
}
