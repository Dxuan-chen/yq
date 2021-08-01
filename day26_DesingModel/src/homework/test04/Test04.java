package homework.test04;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Test04 {
    public static void main(String[] args) {
        Robot robot = new Robot();
        robot.run();
        robot.speek();
        Ariplane ariplane = new Ariplane();
        ariplane.run();
        ariplane.fly();
    }
}
