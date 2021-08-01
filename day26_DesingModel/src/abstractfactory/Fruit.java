package abstractfactory;

/**
* 简单工厂实现流程:
* 1.棍据需要创建的对象类型，抽取出一个父类型接口
* 2.提供一个工厂方法，用于根据指定的参数(对象类型)实现创建一个父接口类型对象
*/
public interface Fruit {//为了所有水果可以返回
    public void showMe();
}
