package homework.test01;

import java.io.Console;

/**
 * 功能描述：
 *
 * @author 陈铉锋
 * @date 2021/7/20
 */
public class Test01 {
    public static void main(String[] args) {
        ConsoleFactory consoleFactory = new ConsoleFactory();
        ConsoleLog consoleLog = (ConsoleLog) consoleFactory.newInstance();
        consoleFactory.show();
        consoleLog.show();

    }
}
