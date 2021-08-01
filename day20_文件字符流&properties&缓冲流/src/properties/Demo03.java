package properties;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/12
 */
public class Demo03 {
    @Test
    public void test01() throws IOException {
        Properties properties = new Properties();
        FileReader is = new FileReader("a.properties");
        properties.load(is);

        String fileName1 = properties.getProperty("fileName");
        System.out.println("fileName="+fileName1);
        String location1 = properties.getProperty("location");
        System.out.println("location="+location1);
    }

    @Test
    public void test02() throws IOException {
        Properties properties = new Properties();

        FileReader is = new FileReader("a.properties");
        properties.load(is);


    }
}
