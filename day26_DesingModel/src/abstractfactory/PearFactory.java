package abstractfactory;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class PearFactory implements FruitFactory{
    @Override
    public Fruit newIstance() {
        return new Pear();
    }
}
