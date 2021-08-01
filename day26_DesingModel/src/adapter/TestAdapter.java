package adapter;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class TestAdapter {
    public static void main(String[] args) {
        //电脑读取一个SDCard
        //1.创建SDCard
        SDCard sdCard = new SDCard();
        //2.创建转接器 并且 插入SD卡
        CardReaderAdapter sdCardAdapter= new CardReaderAdapter(sdCard);
        //3.电脑创建 并且 插入USB设备 转接器
        Computer computer = new Computer(sdCardAdapter);
        computer.useUsb();
        //电脑读取一个TF卡
        TFCard tfCard = new TFCard();
        CardReaderAdapter tfCardAdapter = new CardReaderAdapter(tfCard);
        Computer computer2 = new Computer(tfCardAdapter);
        computer2.useUsb();

    }
}
