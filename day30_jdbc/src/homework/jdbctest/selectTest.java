package homework.jdbctest;

import homework.util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/26
 */
public class selectTest {
    public static void main(String[] args) {
        select01();
    }

    private static void select01() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            con = JDBCUtils.getConnection();
            String sql = "select Teacher.Tname,a.* from Teacher,\n" +
                    "(select STid,count(Sid) from Student group by STid)as a \n" +
                    "WHERE teacher.Tid=a.STid;";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String tname = rs.getString(1);
                String tid = rs.getString(2);
                int count = rs.getInt(3);
                System.out.println("tname:"+tname+"  tid:"+tid+"  count:"+count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,con);
        }
    }
}
