package poker;

import java.util.*;

/**
 * 存牌
 * 洗牌
 * 发牌
 * 排序
 * 显示
 */
public class poker {
    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        for (int i = 1;i <= 10;i ++){
            numbers.add(String.valueOf(i));
        }
        Collections.addAll(numbers,"J","Q","k");
        Collections.addAll(colors,"♦", "♣", "♥", "♠");

        LinkedHashMap<Integer,String> pokers = new LinkedHashMap<>();
        int i = 0;
        for(int j = 0;j < numbers.size();j ++){
            for(int k = 0;k < colors.size();k ++){
                pokers.put(i++,numbers.get(j)+colors.get(k));
            }
        }
        pokers.put(i++,"大王");
        pokers.put(i++,"小王");
        Set<Map.Entry<Integer, String>> entries = pokers.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry);
        }
        //洗牌
        System.out.println("洗牌.......");
        Set<Integer> integerSet = pokers.keySet();
        ArrayList<Integer> keys = new ArrayList<>();
        keys.addAll(integerSet);
        Collections.shuffle(keys);

        //发牌
        System.out.println("发牌.......");
        ArrayList<String> lasts = new ArrayList<>();
        ArrayList<String> person1 = new ArrayList<>();
        ArrayList<String> person2 = new ArrayList<>();
        ArrayList<String> person3 = new ArrayList<>();
        int q = 1;
        for (Integer integer : keys) {
            if(q%3==0){
                person1.add(pokers.get(integer));
            }
            if(q%3==1){
                person2.add(pokers.get(integer));
            }
            if(q%3==2){
                person3.add(pokers.get(integer));
            }
            if(q>51){
                lasts.add(pokers.get(integer));
            }
            q++;
        }

        //排序
        print(lasts,person1,person2,person3);
        System.out.println("排序......");
        Collections.sort(lasts);
        Collections.sort(person1);
        Collections.sort(person2);
        Collections.sort(person3);
        print(lasts,person1,person2,person3);
    }

    //显示
    public static void print(ArrayList<String> list,ArrayList<String> list1,ArrayList<String> list2,ArrayList<String> list3){
        System.out.print("底牌:");
        for (String s : list) {
            System.out.print(s);
        }
        System.out.println();
        System.out.print("person1:");
        for (String s : list1) {
            System.out.print(s);
        }
        System.out.println();
        System.out.print("person2:");
        for (String s : list2) {
            System.out.print(s);
        }
        System.out.println();
        System.out.print("person3:");
        for (String s : list3) {
            System.out.print(s);
        }
        System.out.println();
    }
}
