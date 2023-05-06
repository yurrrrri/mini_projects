package app.syr.project1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("가위바위보 게임이 시작되었습니다.");

        System.out.println("당신의 이름 또는 닉네임을 입력해주세요.");
        String username = br.readLine();

        int winCount = 0;
        int loseCount = 0;

        while(true) {
            System.out.println("\n가위, 바위, 보 중 하나를 입력해주세요. (게임 종료 : X)");
            String user = br.readLine();

            if(user.equals("X")) break;

            int number = (int) (Math.random() * 3);
            String[] rps = new String[]{"가위", "바위", "보"};
            String computer = rps[number];

            if(user.equals(computer)) System.out.println("비겼습니다.");
            else if(user.equals("가위")){
                if(computer.equals("바위")) {
                    System.out.println("졌습니다...");
                    loseCount++;
                } else {
                    System.out.println("이겼습니다!!!");
                    winCount++;
                }
            } else if(user.equals("바위")) {
                if(computer.equals("가위")) {
                    System.out.println("이겼습니다!!!");
                    winCount++;
                } else {
                    System.out.println("졌습니다...");
                    loseCount++;
                }
            } else if(user.equals("보")) {
                if(computer.equals("가위")) {
                    System.out.println("졌습니다...");
                    loseCount++;
                } else {
                    System.out.println("이겼습니다!!!");
                    winCount++;
                }
            } else {
                System.out.println("올바른 단어를 입력해주세요. (게임 종료 : x)");
            }
        }

        System.out.println("========== 최종 결과 ==========");
        System.out.println("[%s] : %d / [컴퓨터] : %d".formatted(username, winCount, loseCount));
        System.out.println("==============================");
        System.out.println("가위바위보 게임이 종료되었습니다.");

        br.close();
    }
}