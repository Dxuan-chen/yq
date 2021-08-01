package homework.test01;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class FileFactory implements LogFactory {
    @Override
    public IWriteLog newInstance() {
        return new FileLog();
    }

    @Override
    public void show() {
        System.out.println("记录日志...");
    }
}
