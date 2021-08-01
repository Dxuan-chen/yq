package adapter;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Computer {
    //支持接入usb设备
    Usb usb;

    public Computer(Usb usb) {
        this.usb = usb;
    }

    public Computer() {
    }

    //使用usb设备
    public void useUsb(){
        System.out.println("使用usb......");
        usb.read();
    }
}
