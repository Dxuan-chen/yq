package decorate;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class TestDecorate {
    public static void main(String[] args) {
        Girl englandGirl = new EnglandGirl();
        System.out.println(englandGirl.getDesc());

        //装饰类
        ArtGirl artGirl = new ArtGirl(englandGirl);
        System.out.println(artGirl.getDesc());
        artGirl.draw();
        SportGirl sportGirl = new SportGirl(englandGirl);
        System.out.println(sportGirl.getDesc());
        sportGirl.dance();
    }
}
