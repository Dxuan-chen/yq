package dataSourceTest;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/27
 */
public class Test {
    public static void main(String[] args) {
        while (true){
            try {
                Connection con = DataSource.getConnection();
                System.out.println(con);

                Thread.sleep(1000);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
