package homework.test01;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/21
 */
public class Person {
    private String name;
    private int age;
    private Date birthday;
    private Sex sex;

    public Person(String name, int age, Date birthday, Sex sex) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        String bir = new SimpleDateFormat("yyyy-MM-dd").format(birthday);
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + bir +
                ", sex=" + sex +
                '}';
    }
}
