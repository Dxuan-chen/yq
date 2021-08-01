package factorytest;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class MediaFactory implements IFactory {
    @Override
    public IFridge createFridge() {
        return new MediaFridge();
    }

    @Override
    public AirBox createAirBox() {
        return new MediaAirBox();
    }
}
