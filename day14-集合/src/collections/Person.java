package collections;

import java.util.Objects;

/*实现了可比较接口，才能使用sort排序*/
public class Person implements Comparable<Person>{
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    //比较通过equals实现
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    //找到存储位置下标关键方法
    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    /*
    * 自然升序  当前对象的值-传入对象的值
    */
    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }
}
