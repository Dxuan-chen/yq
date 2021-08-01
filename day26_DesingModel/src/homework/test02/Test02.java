package homework.test02;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Test02 {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        Pig pig = (Pig)animalFactory.newInstance("pig");
        pig.show();
        Cattle cattle = (Cattle)animalFactory.newInstance("cattle");
        cattle.show();


    }
}
