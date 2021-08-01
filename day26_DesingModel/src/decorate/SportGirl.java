package decorate;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class SportGirl extends GirlDecorate {
    private Girl girl;

    public SportGirl() {
    }
    public SportGirl(Girl girl) {
        this.girl = girl;
    }
    @Override
    public String getDesc() {
        return "爱运动的女孩...";
    }
    public void dance(){
        System.out.println("爱运动的女孩会跳舞...");
    }
}
