package homework.test28;

import java.util.Scanner;

/**
 *
 */
public class Test28 {
    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("账号：");
            String accountNumber = sc.nextLine();
            System.out.println("余额：");
            int money = sc.nextInt();
            try {
                DebitCard card = new DebitCard(accountNumber, money);
            } catch (MoneyException e) {
                e.printStackTrace();
                System.out.println("保存失败");
                return ;
            }
            System.out.println("保存成功");
        }
    }
}
