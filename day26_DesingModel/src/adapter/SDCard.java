package adapter;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class SDCard implements Card {
    @Override
    public void readCard() {
        System.out.println("sd卡开始读取...");
    }

    @Override
    public void writeCard() {

    }
}
