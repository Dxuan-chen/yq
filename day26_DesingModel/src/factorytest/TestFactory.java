package factorytest;

/**
 * 功能描述：有两个工厂，美的、格力。
 * 这两个工厂都生产两种产品：冰箱和空调，请用工厂设计模式实现该案例
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class TestFactory {
    public static void main(String[] args) {
        MediaFactory mediaFactory = new MediaFactory();
        AirBox airBox = mediaFactory.createAirBox();
        airBox.condition();
        IFridge fridge = mediaFactory.createFridge();
        fridge.cold();
        test1();
        test2();
    }

    private static void test2() {
        int b = 50;
        ++b;
        ++b;
        ++b;
        ++b;
        System.out.println(b);
    }

    private static void test1() {
        int a = 9;
        ++a;
        ++a;
        ++a;
        ++a;
        System.out.println(a);

//        Object o = null;
//        o.toString();
    }
}
