package homework.test01;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class DBFactory implements LogFactory {
    @Override
    public IWriteLog newInstance() {
        return new DBLog();
    }

    @Override
    public void show() {
        System.out.println("记录日志...");
    }
}
