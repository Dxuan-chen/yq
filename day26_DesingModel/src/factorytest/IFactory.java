package factorytest;

public interface IFactory {
    //生产冰箱产品
    IFridge createFridge();
    //生产空调产品
    AirBox createAirBox();
}
