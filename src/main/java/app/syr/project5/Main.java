/*
좌석 예매 프로그램
 */
package app.syr.project5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 10*4 좌석, 조회/예약/예약취소/예약 확인/종료
        // 각 좌석은 [좌석번호, "", ""], 예약한 경우 [좌석번호, 예약자, 예약자_비밀번호]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("좌석 예매 프로그램을 시작합니다.");
        System.out.println("원하는 작업을 선택해주세요. (1) 조회 / (2) 예약 / (3) 예약 취소 / (4) 예약 확인 / (0) 프로그램 종료");
        int answer = Integer.parseInt(br.readLine());



    }
}
