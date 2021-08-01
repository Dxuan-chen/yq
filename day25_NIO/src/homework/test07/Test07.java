package homework.test07;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/19
 */
public class Test07 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Properties pro = new Properties();
        File file = new File("day25_NIO/src/homework/test07/test07Attribute.properties");
        File file2 = new File("day25_NIO/src/homework/test07/test07.properties");
        String[] files = file.getPath().split("/");
        if(!file.exists()){
            for(int i = 0;i < files.length;i++){
                    new File(files[i]).mkdir();
            }
            file.createNewFile();
        }
        pro.load(new InputStreamReader(new FileInputStream(file),"utf-8"));

        Properties pro2 = new Properties();
        pro2.load(new InputStreamReader(new FileInputStream(file2),"utf-8"));
        Class<DemoClass> dClass = (Class<DemoClass>)Class.forName(pro2.getProperty("class"));
        DemoClass demo = dClass.newInstance();
        Method method = dClass.getDeclaredMethod("run");
        method.setAccessible(true);


        while (true) {
            method.invoke(demo);
            if ("null".equals(pro.getProperty("count"))) {
                pro.setProperty("count", "0");
            } else {
                pro.setProperty("count", Integer.parseInt(pro.getProperty("count"))+1+"");
                if (Integer.parseInt(pro.getProperty("count")) > 3) {
                    break;
                }
            }

        }
        FileOutputStream fos = new FileOutputStream(file);
        pro.store(fos,"#");
    }
}
