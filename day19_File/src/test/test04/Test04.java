package test.test04;

import java.util.Scanner;

/**
 *
 */
public class Test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true){
            int score = sc.nextInt();
            if(score >= 0&&score  <= 100){
                System.out.println(score);
            }else {
                throw new ScoreException("分数必须在0—100之间");
            }
        }

    }
}
