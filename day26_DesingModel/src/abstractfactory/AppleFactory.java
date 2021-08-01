package abstractfactory;

/**
 * 设计apple的对象工厂，用于专门生产apple对象，并且提供appLe对象的处理功能
 */
public class AppleFactory implements FruitFactory {
    @Override
    public Fruit newIstance() {
        return new Apple();
    }
}
