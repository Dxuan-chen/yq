package ref;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Demo01 {


    Class<Student> studentClass = null;


    @Before
    public void before(){
        studentClass  = Student.class;
    }


    /**
     * 反射:在程序运行期间动态的探知和修改类的结构
     * 本质就是获取字节码文件对象(.class加载到虚拟机会创建一个对应的唯一对象)，并且修改其属性
     * <p>
     * 作用：
     * 可以实现动态的获取类信息功能
     * <p>
     * <p>
     * 实现反射第一步：
     * 获取类的字节码文件对象
     * a.类名.class
     * b.Object提供的 getClass()
     * <p>
     * Class：描述类的类型
     */
    @Test
    public void test01() throws ClassNotFoundException {
        //获取Class对象的三种方式
        //1.方式一:通过类名.class获取
        Class<Student> studentClass = Student.class;
        System.out.println(studentClass);
        //2.方式二:通过Object类的成员方法getClass()方法获取
        Student student = new Student();
        Class<Student> studentClass2 = (Class<Student>)student.getClass();
        System.out.println(studentClass2);
        //3.方式三:通过Class.forName(“全限定类名”)方法获取
        //ClassNotFoundException 类找不到异常
        Class<?> studentClass3 = Class.forName("ref.Demo01");
        System.out.println(studentClass3);
    }


    @Test
    public void test02() throws IllegalAccessException, InstantiationException {
        System.out.println("全限定类名:"+studentClass.getName());
        System.out.println("类名:"+studentClass.getSimpleName());
        System.out.println("包名:"+studentClass.getPackageName());
        System.out.println("获取类型名称:"+studentClass.getTypeName());
        //根据无参构造方法创建一个student对象
        //如果没有无参构造方法，会报实例化异常InstantiationException
        //java.lang.NoSuchMethodException:ref.Student.<init>()
        Student student = studentClass.newInstance();
        System.out.println(student);

    }

    /**
    * 构造方法
    */
    @Test
    public void test03() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获取所有public修饰的构造方法
        Constructor<?>[] constructors = studentClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        //根据指定参数获取构造方法
        Constructor<Student> constructor = studentClass.getConstructor();
        Student student = constructor.newInstance();//替代原字节码文件对象的newInstance
        Constructor<Student> constructor2 = studentClass.getConstructor(String.class, String.class, int.class);
        Student student1 = constructor2.newInstance("张三", "男", 58);
        //获取全部构造方法 包括私有
        Constructor<?>[] declaredConstructors = studentClass.getDeclaredConstructors();
        for (Constructor<?> construct : declaredConstructors) {
            System.out.println(construct);
        }
    }

    /*
    * Method:描述方法的类型    Method[]: 以方法对象为元素的数组
    */
    @Test
    public void test04() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //获取父类型字节码对象
        Class<? super Student> superclass = studentClass.getSuperclass();
        System.out.println(superclass);

        Method[] methods = studentClass.getMethods();
        System.out.println("获取所有公共的方法：");
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("------------------");
        System.out.println("获取本类所有的方法");
        Method[] declaredMethods = studentClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("获取私有方法show:");
        Method showMethod = studentClass.getDeclaredMethod("show");
        System.out.println(showMethod);
        showMethod.setAccessible(true);//设置可访问
        //方法调用invoke(Object obj,Object... args):
        //obj:调用方法的对象，如果是static方法，则为null args：参数列表
        Student student = studentClass.newInstance();
        /*Object invoke = */showMethod.invoke(student);
        System.out.println("调用静态方法");
        Method studyMethod = studentClass.getMethod("study");
        studyMethod.invoke(null);

        Method eatMethod = studentClass.getMethod("eat");
        eatMethod.invoke(studentClass.newInstance());

    }

    //属性处理Field
    @Test
    public void test06() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        System.out.println("获取所有属性");
        Field[] declaredFields = studentClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println("获取某个私有属性，进行操作");
        Field ageField = studentClass.getDeclaredField("age");
        System.out.println(ageField);
        ageField.setAccessible(true);
        System.out.println(ageField);

        Class<?> type = ageField.getType();
        System.out.println("属性类型："+type);

        Student student = studentClass.newInstance();
        System.out.println("当前student:"+student);
        //ageField.set(对象，值)，为对象设置值
        ageField.set(student,10);
        System.out.println("当前student:"+student);
        Object o = ageField.get(student);//获取当前student对象身上的age属性值
        System.out.println("获取当前student对象身上的age属性值"+o);

    }




}
