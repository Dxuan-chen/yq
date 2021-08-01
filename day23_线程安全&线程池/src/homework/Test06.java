package homework;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/15
 */
public class Test06 {
    public static void main(String[] args) {
        Person p = new Person();
        Thread thread01 = new Thread(new IntputRunnable(p));
        Thread thread02 = new Thread(new OutputRunnable(p));
        thread01.start();
        thread02.start();
    }
}

class IntputRunnable implements Runnable {
    private Person person;

    public IntputRunnable(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            synchronized(person){
                while (person.flag) {
                    person.setName("李华");
                    person.setSex("男");
                    System.out.println("赋值");
                    person.flag = false;
                }
                person.notify();
                try {
                    person.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class OutputRunnable implements Runnable {
    private Person person = new Person();

    public OutputRunnable(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            synchronized(person){
                while (!person.flag) {
                    System.out.println(person);
                    person.flag = true;
                }
                person.notify();
                try {
                    person.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Person {
    private String name;
    private String sex;
    public boolean flag;

    public Person(String name, String sex) {
        this.name = name;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
