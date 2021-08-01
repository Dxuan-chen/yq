package factorytest;

/**
 *
 */
public class MediaAirBox implements AirBox {
    @Override
    public void condition() {
        System.out.println("美的空调制冷...");
    }
}
