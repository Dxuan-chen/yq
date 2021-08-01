package homework.test05;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HelloWorld {
    public static void main(String[] args){
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("2017001", false, 0));
        users.add(new User("2017002", true, 36));
        users.add(new User("2017003", false, 98));
        users.add(new User("2017004", false, 233));
        users.add(new User("2017005", true, 68));
        users.add(new User("2017006", true, 599));
        users.add(new User("2017007", true, 1023));
        users.add(new User("2017008", false, 9));
        users.add(new User("2017009", false, 66));
        users.add(new User("2017010", false, 88));

        //普通实现方式

        for (int i = 0;i < 3;i ++) {
            System.out.println(users.get(i).getUserID());
        }

        System.out.println("----------------------");
        //Stream API实现方式
        List<String> list1 = users.stream().filter(e -> e.isVip()).limit(3).map(e -> e.getUserID()).collect(Collectors.toList());
        list1.stream().forEach(System.out::println);
    }
}
