package homework.test04;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Ariplane extends Car {
    @Override
    public void run() {
        System.out.println("飞机在陆地上移动");
    }
    public void fly(){
        System.out.println("飞机在天空中飞");
    }
}
