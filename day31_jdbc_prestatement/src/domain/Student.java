package domain;

import java.util.Date;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/27
 */
public class Student {
    private String sId;
    private String name;
    private Date age;
    private String sex;
    private String strAgeDate;


    public Student() {

    }

    public Student(String sId, String name, Date age, String sex) {
        this.sId = sId;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getStrAgeDate() {
        return strAgeDate;
    }

    public void setStrAgeDate(String strAgeDate) {
        this.strAgeDate = strAgeDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
