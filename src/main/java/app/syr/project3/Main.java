/*
로또 번호 생성 프로그램
 */
package app.syr.project3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("로또 번호 생성 프로그램을 시작합니다.");

        int answer = 0;
        while(true){
            System.out.println("로또 번호를 총 몇 번 생성하시겠습니까? (최소) : 1 / (최대) : 5");

            try {
                answer = Integer.parseInt(br.readLine());

                if(answer < 1 || answer > 5)
                    System.out.println("로또 번호는 최소 1번에서 최대 5번까지 생성 가능합니다.");
                else break;
            } catch(NumberFormatException e) {
                System.out.println("정확한 숫자를 입력해주세요. (최소) : 1 / (최대) : 5");
            }
        }

        for(int i=0; i<answer; i++){
            System.out.println("=".repeat(20));
            System.out.println("<< %d번째 로또 번호 >>".formatted(i + 1));

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            List<Integer> lotto = new ArrayList<>();

            for(int j=0; j<6; j++){
                int number = (int) (Math.random() * 44 + 1);
                lotto.add(number);
            }

            for(int k=1; k<=45; k++){
                if(lotto.contains(k)){
                    sb1.append(k + " ");
                    sb2.append("■ ");
                } else sb2.append("□ ");
                if(k % 6 == 0) sb2.append("\n");
            }

            System.out.println(sb1);
            System.out.println(sb2);
            System.out.println("=".repeat(20));
        }

        System.out.println("로또 번호 생성 프로그램을 종료합니다.");

        br.close();
    }
}
