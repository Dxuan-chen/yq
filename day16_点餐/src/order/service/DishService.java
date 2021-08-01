package order.service;

import order.entity.Dishes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能描述：Dishes服务处理具体类
 */
public class DishService implements IService<Dishes> {
    //存放系统中所有的菜品
    Map<String, Dishes> dishesMap = new HashMap<>();

    @Override
    public void add(Dishes dishes) {
        dishesMap.put(dishes.getId(),dishes);
    }

    @Override
    public Dishes remove(String id) {
        return dishesMap.remove(id);
    }

    @Override
    public void update(Dishes dishes) {
        dishesMap.put(dishes.getId(),dishes);
    }

    @Override
    public Dishes get(String id) {
        return dishesMap.get(id);
    }

    @Override
    public List<Dishes> getAll() {
        Set<Map.Entry<String, Dishes>> entries = dishesMap.entrySet();
        ArrayList<Dishes> list = new ArrayList<>();
        for (Map.Entry<String, Dishes> entry : entries) {
            list.add(entry.getValue());
        }
        return list;
    }

    //添加菜品
    public void addMenu(Scanner scanner){
        System.out.println("请输入菜品信息，格式:菜品id/菜品名/菜品类型(面食、 米饭 、火锅、粤菜…)/上架时间/单价/月销售/总数量");
        String next = scanner.nextLine();
        String[] split = next.split("/");
        if(split.length!=7){
            System.out.println("输入有误，请重输入");
            addMenu(scanner);
        }else {
            String dateStr = split[3];
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
            Date date = null;
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            double price = Double.parseDouble(split[4]);
            int sales = Integer.parseInt(split[5]);
            int stocks = Integer.parseInt(split[6]);
            Dishes dishes = new Dishes(split[0],split[1],split[2],date,price,sales,stocks);
            add(dishes);
        }
    }

    /*
     * 根据指定菜品类别查看菜品信息
     * 1.查询出所有类别信息
     * 2.提示输入
     * 3.获取输入的类别信息，查询是否存在
     * 存在输出
     * 不存在则提示
     * */
    public void getType(Scanner scanner){
        List<String> types = getAllType();
        System.out.println("当前的类别有:"+types);
        String next = scanner.nextLine();
        ArrayList<Dishes> list = new ArrayList<>();
        //找出是否存在
        Set<String> keySet = dishesMap.keySet();
        for (String key : keySet) {
            Dishes dishes = dishesMap.get(key);
            if(dishes.getType().equals(next)){
                list.add(dishes);
            }
        }
        if(list.size()>0){
            System.out.println("当前类别下的菜品有:"+list);
        }else{
            System.out.println("当前类别无菜品");
        }
        
    }

    /*获取所有类别，要去重*/
    private List<String> getAllType() {
        List<Dishes> dishes = getAll();
        List<String> types = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (Dishes dish : dishes) {
            set.add(dish.getType());
        }//放入set集合中，实现去重
        types.addAll(set);
        return types;
    }

    /*
     * 1.根据id查找菜品
     * 2.根据输入的价格，修改菜品
     * */
    public void updatePrice(Scanner scanner){
        System.out.println("请输入需要修改的菜品id:");
        String id = scanner.nextLine();
        Dishes dishes = get(id);
        System.out.println("菜品:"+dishes);
        System.out.println("请输入新的价格:");
        double price = scanner.nextDouble();
        dishes.setPrice(price);
        dishesMap.put(id,dishes);//替换原来的菜品
        System.out.println("修改完成，菜品信息:"+dishesMap.get(id));
    }

    /**
     * 显示所有菜品(按菜品销量从高到低排序输出)
     */
    public void getAllDishes(){
        List<Dishes> list = getAll();
        Collections.sort(list,new Comparator<Dishes>(){
            @Override
            public int compare(Dishes d1, Dishes d2) {
                return d2.getSales()-d1.getSales();
            }
        });
        System.out.println(list);
    }
}
