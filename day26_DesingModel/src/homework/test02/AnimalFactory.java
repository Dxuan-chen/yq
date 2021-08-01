package homework.test02;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class AnimalFactory {
    public static IAnimal newInstance(String type){
        if("cattle".equals(type)){
            return new Cattle();
        }else if("pig".equals(type)){
            return new Pig();
        }
        return null;
    }
}
