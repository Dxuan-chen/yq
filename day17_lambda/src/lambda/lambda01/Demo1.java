package lambda.lambda01;

/**
 *
 */
public class Demo1 {
    public static void main(String[] args) {
        //匿名内部类写法（接口 子类 重写方法
        new Start(new Task() {
            @Override
            public void task() {
                System.out.println("开始任务啦！");
            }
        }).run();

        //lambda表达式写法
        new Start(() -> System.out.println("使用lambda表达式开启任务！"));
    }
}
