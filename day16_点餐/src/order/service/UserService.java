package order.service;

import order.entity.Admin;
import order.entity.User;

import java.util.*;

/**
 *
 */
public class UserService implements IService<User> {
    Map<String,User> userMap = new HashMap<>();
    @Override
    public void add(User user) {
        userMap.put(user.getId(),user);
    }

    @Override
    public User remove(String id) {
        return userMap.remove(id);
    }

    @Override
    public void update(User user) {
        userMap.put(user.getId(),user);
    }

    @Override
    public User get(String id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getAll() {
        Set<Map.Entry<String, User>> entries = userMap.entrySet();
        ArrayList<User> user = new ArrayList<>();
        for (Map.Entry<String, User> entry : entries) {
            user.add(entry.getValue());
        }
        return user;
    }

    //查询用户名是否存在
    public boolean checkName(String username){
        Set<Map.Entry<String,User>> entries = userMap.entrySet();
        for (Map.Entry<String, User> entry : entries) {
            User user = entry.getValue();
            if(user.getUserName().equals(username)){
                return true;
            }
        }
        return false;
    }

    //校验密码是否正确
    public boolean checkPwd(String pwd){
        Set<Map.Entry<String,User>> entries = userMap.entrySet();
        for (Map.Entry<String, User> entry : entries) {
            User user = entry.getValue();
            if(user.getPassword().equals(pwd)){
                return true;
            }
        }
        return false;
    }

    public void addMenu(Scanner scanner){
        System.out.println("请输入客户信息，格式:id/姓名/性别/密码/送餐地址/手机号");
        String next = scanner.next();
        String[] split = next.split("/");
        if(split.length!=6){
            System.out.println("输入有误，请重输入");
            addMenu(scanner);
        }else {
            Date date = new Date();
            User user = new User(split[0], split[1], split[2],split[3], split[4],split[5],date);
            add(user);
        }
    }

    public User getByName(String username) {
        Set<Map.Entry<String, User>> entries = userMap.entrySet();
        for (Map.Entry<String, User> entry : entries) {
            User user = entry.getValue();
            if(user.getUserName().equals(username)){//用户名匹配上则表示有该用户
                return user;
            }
        }
        return null;//不存在
    }
}
