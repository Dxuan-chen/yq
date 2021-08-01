package simplefactory;

/**
 * 提供水果对象创建的工厂
 */
public class FruitFactory {
    /**
    * 创建水果对象的工厂方法
    *@date 2021/7/20 14:47
    *@param type
    *@return simplefactory.Fruit
    */
    public static Fruit newInstance(String type){
        if("apple".equals(type)){
            return new Apple();
        }else if("pear".equals(type)){
            return new Pear();
        }
        return null;
    }
}
