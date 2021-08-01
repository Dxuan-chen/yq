package homework;

import java.io.File;
import java.util.*;

/**
 * 功能描述：键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数
 */
public class Test21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要统计的文件夹路径：");
        String path = sc.nextLine();
        File file = new File(path);
        List<File> list = new ArrayList<>();
        findFiles(file,list);

        Map<String,Integer> map = new HashMap<>();
        findFilesKind(list,map);
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            int value = map.get(key);
            System.out.println(key+"的类型的文件有"+value+"个");
        }
    }

    private static void findFilesKind(List<File> list,Map<String,Integer> map) {
        for (File f : list) {
            String[] strs = f.getName().split("\\.");
            if(!map.containsKey(strs[strs.length-1])){
                map.put(strs[strs.length-1],1);
            }else{
                map.put(strs[strs.length-1],map.get(strs[strs.length-1])+1);
            }
        }
    }

    private static void findFiles(File file,List<File> list) {
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                findFiles(f,list);
            }else{
                list.add(f);
            }
        }
    }
}
