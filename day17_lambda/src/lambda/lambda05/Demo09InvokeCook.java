package lambda.lambda05;

/**
 *
 */
public class Demo09InvokeCook {
    public static void main(String[] args) {
        invokeCook(() -> System.out.println("吃饭啦！"));
    }

    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }
}
