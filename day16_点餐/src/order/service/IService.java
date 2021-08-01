package order.service;

import java.util.List;
import java.util.Map;

/**
* 服务接口：定义系统中统一的方法设计
 * 增
 * 删
 * 改
 * 查
 * 查所有
*/
public interface IService <T>{

    //增
    void add (T t);

    //删
    T remove(String id);

    //改
    void update(T t);

    //查
    T get(String id);

    //
    List<T> getAll();
}
