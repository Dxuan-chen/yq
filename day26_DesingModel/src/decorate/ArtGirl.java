package decorate;

/**
 *
 */
public class ArtGirl extends GirlDecorate{
    private Girl girl;

    public ArtGirl(Girl girl) {
        this.girl = girl;
    }
    public ArtGirl() {
    }
    @Override
    public String getDesc() {//重写描述方法
        return "爱艺术的女孩...";
    }
    public void draw(){//扩展功能
        System.out.println("爱艺术的女孩会画画...");
    }
}
