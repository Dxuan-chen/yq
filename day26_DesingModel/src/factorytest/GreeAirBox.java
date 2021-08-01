package factorytest;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class GreeAirBox implements AirBox {
    @Override
    public void condition() {
        System.out.println("好空调格力造...");
    }
}
