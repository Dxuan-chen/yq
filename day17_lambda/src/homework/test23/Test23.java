package homework.test23;


import java.util.Scanner;

public class Test23 {
    public static char charAt(String str, int index) throws Exception {
        if(str == null){
            throw new Exception("字符串不能为null");
        }
        if("".equals(str)){
            throw new Exception("字符串不能为空");
        }
        if(index < 0||index > str.length()-1){
            throw new Exception("索引越界");
        }
        return str.toCharArray()[index];
    }

    public static void testThrows(String str,int index) throws Exception {
        System.out.println(charAt(str,index));
    }

    public static void testTryCatch(String str,int index){
        try {
            System.out.println(charAt(str,index));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("字符串：");
        String str = sc.nextLine();
        System.out.println("索引：");
        int index = sc.nextInt();

        try {
            testThrows(str,index);
        } catch (Exception e) {
            e.printStackTrace();
        }
        testTryCatch(str,index);
    }
}
