package util;

import java.sql.*;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/27
 */
public class DbUtils {
    private static String url = "jdbc:mysql:///test02";
    private static String username = "root";
    private static String password = "root";
    private static String driver = "com.mysql.jdbc.Driver";

    static{
        Connection con = null;
        try {
            Class.forName(driver);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void close(ResultSet rs, Statement stmt, Connection connection){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Statement stmt, Connection connection){
        close(null,stmt,connection);
    }
}
