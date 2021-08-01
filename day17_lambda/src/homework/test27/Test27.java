package homework.test27;

import java.util.Scanner;

/**
 *
 */
public class Test27 {
    public static void login(String name,String pwd) throws LoginException {
        if(!"root".equals(name)){
            throw new LoginException("用户名不存在");
        }
        if(!"root".equals(pwd)){
            throw new LoginException("密码错误");
        }
        System.out.println("欢迎"+name);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("用户名:");
        String name = sc.nextLine();
        System.out.println("密码:");
        String pwd = sc.nextLine();
        try {
            login(name,pwd);
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
