package dataSourceTest;

import util.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/27
 */
public class DataSource {
    private static int MINCONN = 2;//最小连接数
    private static int MAXCONN = 4;//最大连接数
    private static int POOLSIZE = 0;//总连接数
    private static int WAITTIME = 5000;//5秒等待时间
    private static long OUTTIME = 20000;//20秒超时时间

    private static Map<Connection, Date> pool = new LinkedHashMap<>();//连接池，存放正在使用的连接
    private static Map<Connection, Date> freePool = new LinkedHashMap<>();

    static {//初始化连接池
        for (int i = 0; i < MINCONN; i++) {

            try {
                freePool.put(DbUtils.getConnection(), new Date());
                ++POOLSIZE;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    private static boolean addConnection() throws SQLException {
        if(POOLSIZE < MAXCONN){//总连接数小于最大连接数
            freePool.put(DbUtils.getConnection(),new Date());
            ++POOLSIZE;
            return true;
        }else {
            return false;
        }
    }


    public static Connection getConnection() throws SQLException {
        Connection con = null;
        if(freePool.size() > 0) {//空闲池里有连接
            con = freePool.keySet().iterator().next();//分配空闲池中建立时间最长的连接
            freePool.remove(con);
            pool.put(con,new Date());

            return con;
        }else if(POOLSIZE < MAXCONN) {//总连接数小于最大连接数
            addConnection();//新建一个连接
            con = (Connection) freePool.keySet().toArray()[freePool.size()-1];//分配连接
            freePool.remove(con);
            pool.put(con,new Date());

            return con;
        }else {//当前所开连接池已达到允许的最大连接数
            Date time1 = new Date();
            while (true){
                con = (Connection) pool.keySet().iterator().next();
                Date getTime = pool.get(con);
                Date nowTime = new Date();
                if(OUTTIME<(nowTime.getTime() - getTime.getTime())){//连接使用超时
                    con.close();
                    pool.remove(con);
                    --POOLSIZE;
                    addConnection();//新建一个连接
                    con = (Connection) freePool.keySet().toArray()[freePool.size()-1];//分配连接
                    freePool.remove(con);
                    pool.put(con,new Date());

//                    freePool.put(con,new Date());
//
//                    con = (Connection) freePool.keySet().toArray()[freePool.size()-1];
//                    freePool.remove(con);
//                    pool.put(con,new Date());
                    return con;
                }
                if(WAITTIME<(new Date().getTime()-time1.getTime())){//等待超时
                    return null;
                }
            }

        }
    }

}
