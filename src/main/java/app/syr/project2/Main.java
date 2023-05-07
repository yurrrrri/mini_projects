/*
구구단 게임
 */
package app.syr.project2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("구구단 게임을 시작합니다.");

        System.out.println("당신의 이름 또는 닉네임을 입력해주세요.");
        String username = br.readLine();

        System.out.println("규칙 1 : 0점에서 시작하여 정답을 맞추면 +10점, 틀리면 -5점이 됩니다.");
        System.out.println("규칙 2 : 총 점수가 1000점 이상 또는 -500점 이하가 되면 게임은 자동으로 종료됩니다.");
        System.out.println("규칙 3 : 0을 입력하면 게임이 종료됩니다.");
        System.out.println("%s 님, 구구단 게임을 시작하려면 숫자 1을 입력해주세요.".formatted(username));

        String startGame = br.readLine();

        if(startGame.equals("1")) {
            System.out.println("============== 게임 시작 ==============");

            int score = 0;

            while(true) {
                if(score >= 1000 || score <= -500) break;

                int a = (int) (Math.random() * 7 + 2);
                int b = (int) (Math.random() * 8 + 1);
                System.out.println("\n%d X %d = ?".formatted(a, b));

                int answer = -1;
                try {
                    answer = Integer.parseInt(br.readLine());
                } catch(NumberFormatException e) {
                    System.out.println("정확한 숫자를 입력해주세요. (게임 종료 : 0)");
                    continue;
                }

                if(answer == 0) break;
                else if(answer == a * b){
                    score += 10;
                    System.out.println("정답입니다!!! (현재 점수 : %d)".formatted(score));
                } else {
                    score -= 5;
                    System.out.println("틀렸습니다. (현재 점수 : %d)".formatted(score));
                }
            }
            System.out.println("============== 최종 결과 ==============");
            System.out.println("%s 님의 점수는 %d 점 입니다.".formatted(username, score));
            System.out.println("======================================");
        } else {}

        System.out.println("구구단 게임이 종료되었습니다.");

        br.close();
    }
}
