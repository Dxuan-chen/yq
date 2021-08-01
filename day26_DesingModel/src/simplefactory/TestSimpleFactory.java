package simplefactory;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        Fruit fruit = FruitFactory.newInstance("apple");
        fruit.showMe();
        Fruit fruit1 = FruitFactory.newInstance("pear");
        fruit1.showMe();

    }
}
