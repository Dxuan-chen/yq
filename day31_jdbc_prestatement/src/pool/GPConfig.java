package pool;

/**
 * 功能描述：
 * 定义数据库连接参数
 */
public class GPConfig {
    private String driver;
    private String url;
    private String username;
    private String password;
    //初始化Connection个数
    private String initSize;
    //连接池的最大Connection个数
    private String maxSize;
    //是否自动timeout的检查
    private String health;
    //启动定时器的延期时长（1000）
    private String delay;
    //定时器的时间间隔
    private String period;
    //connection的超时时长
    private String timeout;

    public GPConfig() {
        init();
    }

    public void init(){
        setDriver("com.mysql.jdbc.Driver");
        setUrl("jdbc:mysql://localhost:3306/test02");
        setUsername("root");
        setPassword("root");

        setInitSize(String.valueOf(3));
        setMaxSize(String.valueOf(5));
        setHealth(String.valueOf(true));
        setDelay(String.valueOf(3000));
        setPeriod(String.valueOf(3000));
        setTimeout(String.valueOf(100000));
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getInitSize() {
        return initSize;
    }

    public void setInitSize(String initSize) {
        this.initSize = initSize;
    }

    public String getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(String maxSize) {
        this.maxSize = maxSize;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getDelay() {
        return delay;
    }

    public void setDelay(String delay) {
        this.delay = delay;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }
}
