package ref;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Student {
    // 姓名
    private String name;
    // 性别
    public String sex;
    // 年龄
    private int age;

    //有参构造
    public Student(String name, String sex, int age) {
        System.out.println("有参构造");
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    //私有构造
    private Student(String name, String sex) {
        System.out.println("私有构造");
        this.name = name;
        this.sex = sex;
    }

    //无参构造
    public Student(){
        System.out.println("无参构造");
    }

    //默认修饰符构造
    Student(String name){
        System.out.println("我是默认修饰符");
        this.name=name;
    }

    //protected修饰构造
    protected Student(String name,int age){
        System.out.println("我是protected修饰符");
        this.name=name;
        this.age=age;
    }

    //公有方法
    public void eat(){
        System.out.println("吃饭");
    }

    //有参方法
    public void sleep(int hour){
        System.out.println("我每天睡"+hour+"小时");
    }

    //私有方法
    private void show(){
        System.out.println("表演");
    }

    //静态方法
    public static void study(){
        System.out.println("学习JavaSE");
    }

    //静态私有方法
    private static void studyX(){
        System.out.println("学习JavaEE");
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
