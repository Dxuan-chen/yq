package template;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class WoodHouse extends BuildHouseTemplate{
    @Override
    public void buildWindows() {
        System.out.println("造木窗");
    }
    @Override
    public void buildWall() {
        System.out.println("造木墙");
    }
    @Override
    public void buildFundation() {
        System.out.println("造地基");
    }
}
