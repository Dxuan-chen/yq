package template;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class TestTemplate {
    public static void main(String[] args) {
        WoodHouse woodHouse = new WoodHouse();
        woodHouse.buildHouse();

        RcFrameHouse rcFrameHouse = new RcFrameHouse();
        rcFrameHouse.buildHouse();
    }
}
