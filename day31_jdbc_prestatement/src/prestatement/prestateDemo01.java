package prestatement;

import util.DbUtils;

import java.sql.*;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/27
 */
public class prestateDemo01 {
    public static void main(String[] args) {
        query();
//        deleteStudent("11");
    }

    public static void query(){
        Connection con = null ;
        Statement stmt = null;
        ResultSet rs = null;
        String sql = "select * from student";
        try{
           con = DbUtils.getConnection();
           stmt = con.createStatement();
           rs = stmt.executeQuery(sql);
           while(rs.next()){
               String sid = rs.getString(1);
               String sname = rs.getString(2);
               Timestamp sage = rs.getTimestamp(3);
               String ssex = rs.getString(4);
               String stid = rs.getString(5);
               System.out.println("  Sid:"+sid+"  sname:"+sname+"  sage:"+sage+"  ssex:"+ssex+"  stid:"+stid);
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DbUtils.close(rs,stmt,con);

        }
    }


}
