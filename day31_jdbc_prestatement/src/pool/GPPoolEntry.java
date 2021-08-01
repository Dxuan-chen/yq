package pool;

import java.sql.Connection;

/**
 * 功能描述：
 * 提供Connection对象
 * 连接对象的开始时间点
 */
public class GPPoolEntry {
    //连接对象
    private Connection conn;
    //连接对象开始时间点
    private long startUseTime;

    public Connection getConn(){
        return conn;
    }

    public void setConn(Connection conn){
        this.conn = conn;
    }

    public long getStartUseTime(){
        return startUseTime;
    }

    public void setStartUseTime(long startUseTime){
        this.startUseTime = startUseTime;
    }
}
