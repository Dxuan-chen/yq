package homework.test25;

/**
 *
 */
public class Father {
    public void eat() throws ToothPainException {
        throw new ToothPainException("吃到一个石子");
    }
    public void drink(int water) {
        System.out.println("喝什么都没有问题");
    }
}
