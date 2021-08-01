package homework.test04;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Robot extends Car {
    @Override
    public void run() {
        System.out.println("机器人在陆地上移动");
    }

    public void speek(){
        System.out.println("机器人说话");
    }
}
