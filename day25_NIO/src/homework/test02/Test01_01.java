package homework.test02;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Test01_01 {
    public static void main(String[] args) {
        try {
            Class<Student> sClass = Student.class;
            Student student = sClass.newInstance();
            System.out.println(student);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
