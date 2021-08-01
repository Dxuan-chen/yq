package fileupload;

import util.DbUtils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/27
 */
public class uploadTest {
    public static void main(String[] args) {
        fileupload();
        
        save();
    }

    private static void save() {
    }

    private static void fileupload() {
        Connection con = null;
        PreparedStatement pstmt = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\11879\\Pictures\\yys\\面灵气1920x1080.jpg");
            con = DbUtils.getConnection();
            String sql = "insert into filesdb values(?,?);";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,"面灵气");
            pstmt.setBinaryStream(2,fis);
            int flag = pstmt.executeUpdate();
            if(flag>0){
                System.out.println("添加数据成功");
            }else{
                System.out.println("添加数据失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                pstmt.close();
                con.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

//            DbUtils.close();
        }
    }


}
