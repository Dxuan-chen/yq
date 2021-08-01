package abstractfactory;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        AppleFactory appleFactory = new AppleFactory();
        Fruit fruit = appleFactory.newIstance();
        fruit.showMe();
        appleFactory.showPrice();

        PearFactory pearFactory = new PearFactory();
        Fruit fruit2 = pearFactory.newIstance();
        fruit2.showMe();
        pearFactory.showPrice();
    }
}
