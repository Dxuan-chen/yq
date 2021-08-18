package homework.pojo;

import java.io.Serializable;
import java.util.List;


public class User implements Serializable {
    private String username;
    private String password;
    private String sex;
    private String[] hobby;
    private String city;

    public User() {
    }

    public User(String username, String password, String sex, String[] hobby, String city) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.hobby = hobby;
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", hobby=" + hobby +
                ", city='" + city + '\'' +
                '}';
    }
}
