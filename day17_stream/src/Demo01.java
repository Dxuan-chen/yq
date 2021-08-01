import java.util.ArrayList;
import java.util.Collections;

/**
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list,"abcd","hello world","java","c++","mysql");
        ArrayList<String> resultList = new ArrayList<>();
        for (String s : list) {
            if(s.length()>4){
                resultList.add(s);
            }
        }
        System.out.println("已找出元素："+resultList);

        //Stream实现方式
        System.out.println("stream实现流式操作：");
        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
//        list.stream().filter(s -> s.length()>4).forEach(System.out::println);
    }
}
