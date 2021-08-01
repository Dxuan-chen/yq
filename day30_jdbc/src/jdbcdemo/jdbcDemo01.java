package jdbcdemo;

import java.sql.*;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/26
 */
public class jdbcDemo01 {
    private final static String URL = "jdbc:mysql:///test";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    public static void main(String[] args){
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
        Class.forName("com.mysql.jdbc.Driver");

        con = DriverManager.getConnection(URL,USERNAME,PASSWORD);

        stmt = con.createStatement();

        String sql = "select * from student;";

        rs = stmt.executeQuery(sql);

        while(rs.next()){
            String id = rs.getString(1);
            String name = rs.getString("Sname");
            Date age = rs.getDate("Sage");
            String sex = rs.getString(4);

            System.out.println("--id:"+id+"--name:"+name
                    +"--age:"+age+"--sex:"+sex);
        }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
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

            if(con != null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
