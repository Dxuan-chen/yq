package factorytest;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class GreeFridge implements IFridge {
    @Override
    public void cold() {
        System.out.println("格力冰箱冷藏...");
    }
}
