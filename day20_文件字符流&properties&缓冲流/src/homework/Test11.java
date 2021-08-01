package homework;

import java.io.*;
import java.util.*;

/**
 *
 */
public class Test11 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));
        Scanner sc = new Scanner(System.in);
        String line = null;
        LinkedList<String> list = new LinkedList<>();
        while((line=br.readLine())!=null){
            list.add(line);
        }
        while(true){
            String input = sc.nextLine();
            if(list.contains(input)){
                System.out.println("验证成功");
                break;
            }else{
                System.out.println("验证失败");
            }
        }

    }
}
