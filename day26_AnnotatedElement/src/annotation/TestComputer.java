package annotation;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
@Computer(value = "MAC",price = 20000.0,factories = {"apple","苹果"})
public class TestComputer {

    @Computer(value = "computers",price = 10000.0,factories = {"华为","huawei"})
    public void show(){
        System.out.println("show...");
    }
}
