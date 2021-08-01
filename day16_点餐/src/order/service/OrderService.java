package order.service;

import order.entity.Admin;
import order.entity.Order;

import java.util.*;

/**
 *
 */
public class OrderService implements IService<Order> {
    Map<String, Order> orderMap = new HashMap<>();
    @Override
    public void add(Order order) {
        orderMap.put(order.getOrderId(),order);
    }

    @Override
    public Order remove(String id) {
        return orderMap.remove(id);
    }

    @Override
    public void update(Order order) {
        orderMap.put(order.getOrderId(),order);
    }

    @Override
    public Order get(String id) {
        return orderMap.get(id);
    }

    @Override
    public List<Order> getAll() {
        Set<Map.Entry<String, Order>> entries = orderMap.entrySet();
        ArrayList<Order> order = new ArrayList<>();
        for (Map.Entry<String, Order> entry : entries) {
            order.add(entry.getValue());
        }

        return order;
    }

    /**
     * 根据订单id修改订单状态
     * @param scanner
     */
    public void updateStatue(Scanner scanner){
        System.out.println("请输入需要修改的订单id：");
        String id = scanner.nextLine();
        Order order = get(id);
        System.out.println("已找到订单:"+order);
        System.out.println("请输入新的状态:0-未支付 1-已支付 2-配送中 3-已完成");
        int statue = scanner.nextInt();
        order.setOrderStatue(statue);
        update(order);

    }

    /**
     * 通过用户id查询用户的所有订单，并返回一个list集合
     * @param uid
     * @return
     */
    public List<Order> getByUid(String uid) {
        List<Order> list = new ArrayList<>();
        Set<String> keys = orderMap.keySet();
        for (String key : keys) {
            if (Objects.equals(uid, orderMap.get(key).getUid())) {
                list.add(orderMap.get(key));
            }
        }
        System.out.println("当前已有订单:"+list);
        return list;
    }

}

