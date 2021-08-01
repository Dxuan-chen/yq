package homework.jdbctest;

import homework.util.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/26
 */
public class initTest {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            con = JDBCUtils.getConnection();
            stmt = con.createStatement();
            //创建教师
            String sql1 = "CREATE TABLE Teacher\n" +
                    "(\n" +
                    "\tTid  varchar(10),\n" +
                    "\tTname VARCHAR(10),\n" +
                    "\tprimary key(Tid),\n" +
                    "\tUNIQUE(Tname)\n" +
                    ");";
            stmt.executeUpdate(sql1);

            //创建学生表
            String sql4 = "CREATE TABLE Student\n" +
                    "(\n" +
                    "\tSid varchar(6) PRIMARY KEY,\n" +
                    "\tSname varchar(10),\n" +
                    "\tSage datetime,\n" +
                    "\tSsex varchar(10),\n" +
                    "\tSTid  varchar(10),\n" +
                    "\tconstraint student_teacher_fk foreign key(STid) references Teacher(Tid)\n" +
                    ");";
            stmt.executeUpdate(sql4);

            //创建成绩表
            String sql7 = "CREATE TABLE SC\n" +
                    "(\n" +
                    "\tSid varchar(10) PRIMARY KEY,\n" +
                    "\tCid varchar(10),\n" +
                    "\tscore decimal(18,1),\n" +
                    "\tstu_id  varchar(6),\n" +
                    "\tconstraint student_sc_fk foreign key(stu_id) references Student(Sid)\n" +
                    ");";
            stmt.executeUpdate(sql7);

            //添加老师的数据
            String sql2 = "INSERT INTO Teacher VALUES('t001','张三');";
            String sql3 = "INSERT INTO Teacher VALUES('t002','李四');";

            stmt.executeUpdate(sql2);
            stmt.executeUpdate(sql3);

            //添加学生的数据
            String sql5 = "insert into Student(Sid,Sname,Sage,Ssex,STid)\n" +
                    "values('s001','张三的学生','2002-12-12 13:20:56','男','t001');";
            String sql6 = "insert into Student(Sid,Sname,Sage,Ssex,STid)\n" +
                    "values('s002','李四的学生','2002-12-12 13:20:56','女','t002');";
            stmt.executeUpdate(sql5);
            stmt.executeUpdate(sql6);

            //添加成绩数据
            stmt.executeUpdate("INSERT INTO SC VALUES('st001','java',80,'s001');");
            stmt.executeUpdate("INSERT INTO SC VALUES('st002','C++',90,'s001');");
            stmt.executeUpdate("INSERT INTO SC VALUES('st003','C',60,'s001');");
            stmt.executeUpdate("INSERT INTO SC VALUES('st004','java',95,'s002');");
            stmt.executeUpdate("INSERT INTO SC VALUES('st005','C++',65,'s002');");
            stmt.executeUpdate("INSERT INTO SC VALUES('st006','C',100,'s002');");


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt,con);
        }
    }
}
