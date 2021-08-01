package homework;

import java.io.File;

/**
 *
 */
public class Test07 {
    public static void main(String[] args) {
        File file = new File("D:\\a.txt");
        System.out.println(file.delete()?"a.txt删除成功":"a.txt删除失败");
        File file2 = new File("D:\\aaa");
        if(file2.isDirectory()&&(file2.listFiles()==null||file2.listFiles().length==0)){
            file2.delete();
            System.out.println("aaa删除成功");
        }

    }
}
