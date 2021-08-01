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
public class selectTest02 {
    public static void main(String[] args) {
        select01();
    }

    private static void select01() {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {

            con = JDBCUtils.getConnection();
            String sql = "select b.*,d.* from Teacher as b left join \n" +
                    "(\n" +
                    "select c.STid,a.* from Student as c left join \n" +
                    "(\n" +
                    "select stu_id,max(score) from SC group by SC.stu_id \n" +
                    ") \n" +
                    "as a on c.Sid=a.stu_id \n" +
                    ")\n" +
                    "as d \n" +
                    "on b.Tid=d.STid group by b.Tid;";
            stmt = con.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String tid = rs.getString(1);
                String tname = rs.getString(2);
                String stid = rs.getString(3);
                String stu_id = rs.getString(4);
                int count = rs.getInt(5);
                System.out.println("tid:"+tid+"  tname:"+tname+"  stid:"+stid+"  stu_id:"+stu_id+"  count:"+count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,con);
        }
    }
}
