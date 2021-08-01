package homework.test01;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class DBLog implements IWriteLog {
    @Override
    public void show() {
        System.out.println("数据库记录");
    }
}
