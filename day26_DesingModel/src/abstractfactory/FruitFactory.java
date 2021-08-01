package abstractfactory;

/**
 * 水果工厂接口:提供了水果工厂的创建水果方法的抽象
 */
public interface FruitFactory {
    public Fruit newIstance();

    //设置水果工厂创建的一些通用功能
    default void showPrice(){
        System.out.println("水果不要钱...");
    }
}
