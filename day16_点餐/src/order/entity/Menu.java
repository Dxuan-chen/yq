package order.entity;

import order.service.AdminService;
import order.service.DishService;
import order.service.OrderService;
import order.service.UserService;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * 功能描述：菜单
 */
public class Menu {
    DishService dishService;
    AdminService adminService;
    UserService userService;
    OrderService orderService;

    public Menu(){
        dishService = new DishService();
        adminService = new AdminService();
        userService = new UserService();
        orderService = new OrderService();
    }

    public void showMenu(){
        addMessage();
        System.out.println(dishService.getAll());
        System.out.println(adminService.getAll());
        System.out.println(orderService.getAll());
        System.out.println(userService.getAll());
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入账号和密码,按照账号/密码输入:");
        String str = sc.next();
        String[] split = str.split("/");
        if(split.length!=2){
            System.out.println("输入账号密码有误，请重新输入");
            showMenu();
        }else {
            if(adminService.checkName(split[0])&&adminService.checkPwd(split[1])){
                adminMenu();
            }else if(userService.checkName(split[0])&&userService.checkPwd(split[1])){
                User user = userService.getByName(split[0]);
                userMenu(user);
            }else{
                System.out.println("输入账号密码有误，请重新输入");
                showMenu();
            }
        }
    }

    private void userMenu(User user) {
        System.out.println("***************欢迎来到订餐系统**************");
        System.out.println("【1】点餐************************************");
        System.out.println("【2】根据菜品类别显示所有菜品*****************");
        System.out.println("【3】查看所有订单*****************************");
        System.out.println("【4】修改密码*********************************");
        System.out.println("【5】个人信息显示*****************************");
        System.out.println("【6】退出*************************************");
        System.out.println("请输入您要进行的操作：");
        Scanner scanner = new Scanner(System.in);
        String order = scanner.next();
        switch (order){
            case "1":
                shopDishes(user,scanner);break;
            case "2":
                dishService.getType(scanner);
                break;
            case "3":
                orderService.getByUid(user.getId());
                break;
            case "4":
                System.out.println("请输入新密码:");
                String pwd = scanner.next();
                user.setPassword(pwd);
                userService.update(user);
                System.out.println("更新密码成功");
                break;
            case "5":
                System.out.println(user);
                break;
            case "6":
                System.out.println("再见...");System.exit(0);
            default:
                System.out.println("输入有误，请重新输入");
        }
    }

    private void adminMenu() {
        System.out.println("***************欢迎您尊贵的管理员***************");
        System.out.println("【1】添加菜品***********************************");
        System.out.println("【2】查看所有菜品信息显示************************");
        System.out.println("【3】查看指定类别的菜品信息**********************");
        System.out.println("【4】根据菜品id修改菜品价格**********************");
        System.out.println("【5】删除指定id的菜品****************************");
        System.out.println("【6】添加客户************************************");
        System.out.println("【7】查看客户列表********************************");
        System.out.println("【8】删除指定id的用户****************************");
        System.out.println("【9】订单列表显示********************************");
        System.out.println("【10】根据订单id修改订单状态*********************");
        System.out.println("【11】退出***************************************");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要操作的程序:");
        String order = scanner.nextLine();
        switch (order){
            case "1":
                System.out.println("添加菜单...");
                dishService.addMenu(scanner);
                System.out.println(dishService.getAll());
                break;//10010/十三香小龙虾/川菜/2021年7月6日 13s
            case "2":
                List<Dishes> dishes = dishService.getAll();
                //分页处理
                getPage(scanner,dishes);
                break;
            case "3":
                dishService.getType(scanner);
                break;
            case "4":
                dishService.updatePrice(scanner);
                break;
            case "5":
                System.out.println("请输入要删除的id");
                String id = scanner.nextLine();
                dishService.remove(id);
                System.out.println("删除完成");
                break;
            case "6":
                userService.addMenu(scanner);
                break;
            case "7":
                List<User> users = userService.getAll();
                getPage(scanner,users);
                break;
            case "8":
                System.out.println("请输入需要删除的用户id：");
                id = scanner.nextLine();
                userService.remove(id);
                System.out.println("删除完成");
                break;
            case "9":
                List<Order> orders = orderService.getAll();
                getPage(scanner,orders);
                break;
            case "10":
                orderService.updateStatue(scanner);
                break;
            case "11":
                System.out.println("再见...");
                System.exit(0);
                break;
            default:
                System.out.println("输入有误，请重新输入");
                adminMenu();
        }
        adminMenu();

    }

    private void addMessage() {
        Date time = new Date();
        Dishes d1 = new Dishes("1", "烧鹅", "肉类", time, 12.5, 20, 30);
        dishService.add(d1);
        Dishes d2 = new Dishes("2", "盐焗鸡", "肉类", time, 21.5, 30, 20);
        dishService.add(d2);
        Dishes d3 = new Dishes("3", "麻辣香锅", "火锅类", time, 30, 5, 10);
        dishService.add(d3);
        Dishes d4 = new Dishes("4", "水煮牛肉", "肉类", time, 15, 12, 15);
        dishService.add(d4);
        Dishes d5 = new Dishes("5", "水果沙拉", "水果类", time, 6, 70, 60);
        dishService.add(d5);
        adminService.add(new Admin("10086", "gec", "123456"));

        User u1 = new User("1001", "周瑜", "男", "123456", "湖北", "13545288888", time);
        userService.add(u1);
        User u2 = new User("1002", "孙权", "男", "123456", "湖南", "15927948888", time);
        userService.add(u2);
        User u3 = new User("1003", "孙坚", "男", "123456", "江苏", "15927986854", time);
        userService.add(u3);
        User u4 = new User("1004", "大乔", "女", "123456", "浙江", "18771580888", time);
        userService.add(u4);
        User u5 = new User("1005", "小乔", "女", "123456", "新疆", "18771580777", time);
        userService.add(u5);
        //添加订单
        Order o1 = new Order("1", time, d1, 10, "1001", 60.0, 1);
        orderService.add(o1);
        Order o2 = new Order("2", time, d2, 5, "1002", 50.0, 10);
        orderService.add(o2);
        Order o3 = new Order("3", time, d3, 5, "1003", 40.0, 5);
        orderService.add(o3);
        Order o4 = new Order("4", time, d4, 5, "1004", 30.0, 6);
        orderService.add(o4);
        Order o5 = new Order("5", time, d5, 5, "1005", 20.0, 8);
        orderService.add(o5);

    }

    public <T> void getPage(Scanner scanner,List<T> list){
        //分页处理
        System.out.println("请输入每行需要显示条数:");
        int num = scanner.nextInt();
        for (int i = 1; i <= list.size(); i++) {
            System.out.print(list.get(i-1));
            if(i%num==0){
                System.out.println();
            }
        }
        System.out.println();
    }
    public void shopDishes(User user,Scanner sc) {
        dishService.getAllDishes();
        System.out.println("请输入您要购买的id和数量：按照(id/数量)");
        String str = sc.next();
        String[] info = str.split("/");
        // 判断输入是否符合要求，不符合则要求重新输入
        if (info.length < 2) {
            System.out.println("输入有误，请重新输入：");
            shopDishes(user,sc);
        } else {
            Date time = new Date();
            Dishes dishe = dishService.get(info[0]);//找到菜品
            //待完成，转换异常重新输入
            int num = Integer.parseInt(info[1]);
            if(dishe!=null&&num>0) {
                if(dishe.getStocks()-num>=0) {//库存满足
                    dishe.setStocks(dishe.getStocks() - num);
                    dishe.setSales(dishe.getSales()+num);
                    double orderPrice = dishe.getPrice() * num;
                    Order order = new Order(info[0], time, dishe, num, user.getId(),
                            orderPrice , 0);
                    orderService.add(order);
                    System.out.println("订单已生成！！！" + orderService.get(info[0]));
                    dishService.update(dishe);//更新库存
                }else{
                    System.out.println("库存不足！请重新输入");
                    shopDishes(user,sc);
                }
            }else{
                System.out.println("菜品不存在或输入数量有误,请重新输入：");
                shopDishes(user,sc);
            }
        }
    }

}
