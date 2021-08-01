package lambda.lambda02;

/**
 *
 */
public class Demo05InvokeCook {
    public static void main(String[] args) {

        //1.匿名内部类方式
        invokeCook(new Cook(){
            @Override
            public void makeFood() {
                System.out.println("匿名内部类吃饭啦！");
            }

        });

        //2.lambda表达式方式
        invokeCook(() -> {
            System.out.println("lambda吃饭啦！");
        });

    }
    public static void invokeCook(Cook cook){
        cook.makeFood();
    }
}

