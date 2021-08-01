package beanfactory;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class TestBeanFactory {
    public static void main(String[] args) {
        Apple apple = BeanFactory.newInstance("beanfactory.Apple",Apple.class);
        apple.showMe();

        String str = BeanFactory.newInstance("java.lang.String",String.class);
        //判断isInstance是否是某个类型实例对象
        Class<String> stringClass = String.class;
        System.out.println(stringClass.isInstance("abc"));
    }
}
