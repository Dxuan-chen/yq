package order.service;

import order.entity.Admin;

import java.util.*;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/6
 */
public class AdminService implements IService<Admin> {
    Map<String,Admin> adminMap = new HashMap<>();
    @Override
    public void add(Admin admin) {
        adminMap.put(admin.getId(),admin);
    }

    @Override
    public Admin remove(String id) {
        return adminMap.remove(id);
    }

    @Override
    public void update(Admin admin) {
        adminMap.put(admin.getId(),admin);
    }

    @Override
    public Admin get(String id) {
        return adminMap.get(id);
    }

    @Override
    public List<Admin> getAll() {
        Set<Map.Entry<String, Admin>> entries = adminMap.entrySet();
        ArrayList<Admin> admin = new ArrayList<>();
        for (Map.Entry<String, Admin> entry : entries) {
            admin.add(entry.getValue());
        }

        return admin;
    }

    //查询用户名是否存在
    public boolean checkName(String username){
        Set<Map.Entry<String,Admin>> entries = adminMap.entrySet();
        for (Map.Entry<String, Admin> entry : entries) {
            Admin admin = entry.getValue();
            if(admin.getAccount().equals(username)){
                return true;
            }
        }
        return false;
    }

    //校验密码是否正确
    public boolean checkPwd(String pwd){
        Set<Map.Entry<String,Admin>> entries = adminMap.entrySet();
        for(Map.Entry<String,Admin> entry: entries){
            Admin admin = entry.getValue();
            if(admin.getPassword().equals(pwd)){
                return true;
            }
        }
        return false;
    }
}
