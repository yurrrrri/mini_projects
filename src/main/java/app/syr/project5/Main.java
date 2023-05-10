/*
좌석 예약 프로그램
 */
package app.syr.project5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        // 10*4 좌석, 조회/예약/예약취소/예약 확인/종료
        // 각 좌석은 [좌석번호, "", ""], 예약한 경우 [좌석번호, 예약자, 예약자_비밀번호]
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String[]> map = new HashMap<>();
        for(int i=1; i<=40; i++){
            map.put(i, new String[]{"", ""});
        }

        System.out.println("좌석 예약 프로그램을 시작합니다.");
        while(true){
            System.out.println("원하는 작업을 선택해주세요. (1) 조회 / (2) 예약 / (3) 예약 확인 / (4) 예약 취소 / (0) 프로그램 종료");
            String answer = br.readLine();

            if(answer.equals("0")) break;
            else if(answer.equals("1")){
                checkSeats(map);
            }
            else if(answer.equals("2")){
                reserve(map, br);
            }
            else if(answer.equals("3")){
                mySeat(map, br);
            }
            else if(answer.equals("4")){
                cancel(map, br);
            }
            else System.out.println("올바른 숫자를 입력해주세요.");
        }

        System.out.println("좌석 예약 프로그램이 종료되었습니다.");

        br.close();
    }

    private static void mySeat(Map<Integer, String[]> map, BufferedReader br) throws IOException {
        while(true){
            System.out.print("예약자 성명 : ");
            String name = br.readLine();
            List<Integer> list = new ArrayList<>();
            for(int i=1; i<=map.size(); i++){
                if(map.get(i)[0].equals(name)) list.add(i);
            }
            if(list.isEmpty()) System.out.println("예약하신 좌석이 존재하지 않습니다.");
            else {
                System.out.println("예약하신 좌석 번호는 " + list + " 번 입니다.");
                break;
            }
        }
    }

    private static void cancel(Map<Integer, String[]> map, BufferedReader br) throws IOException {
        System.out.println("예약을 취소할 좌석 번호를 입력해주세요.");
        while(true){
            System.out.print("좌석 번호 : ");
            int seat = Integer.parseInt(br.readLine());
            if(seat < 1 || seat > 40) System.out.println("유효하지 않은 좌석입니다.");
            else if(map.get(seat)[0].equals("")) System.out.println("예약되지 않은 좌석입니다.");
            else {
                System.out.println("예약자 성명과 비밀번호를 입력해주세요.");
                while(true){
                    System.out.print("예약자 성명 : ");
                    String name = br.readLine();
                    if(!map.get(seat)[0].equals(name)) System.out.println("예약자 성명이 일치하지 않습니다.");
                    else {
                        while(true){
                            System.out.print("비밀번호 : ");
                            String pw = br.readLine();
                            if(!map.get(seat)[1].equals(pw)) System.out.println("비밀번호가 일치하지 않습니다.");
                            else break;
                        }
                        break;
                    }
                }
                map.get(seat)[0] = "";
                map.get(seat)[1] = "";
                System.out.println("좌석 예약이 취소되었습니다.");
                break;
            }
        }
    }

    private static void reserve(Map<Integer, String[]> map, BufferedReader br) throws IOException {
        checkSeats(map);
        while(true){
            System.out.println("예약할 좌석을 선택해주세요. (1 ~ 40)");
            int seat = Integer.parseInt(br.readLine());
            if(!map.get(seat)[0].equals("")) System.out.println("이미 예약되어 있는 좌석입니다.");
            else {
                System.out.println("<< " + seat + " 번 좌석 예매 >>");
                System.out.print("예약자 성명 : ");
                String name = br.readLine();
                System.out.print("비밀번호 : ");
                String pw = br.readLine();
                map.get(seat)[0] = name;
                map.get(seat)[1] = pw;
                System.out.println("예약이 완료되었습니다.");
                break;
            }
        }
    }

    private static void checkSeats(Map<Integer, String[]> map) {
        System.out.println("□ : 예약 가능한 좌석 / ■ : 이미 예약된 좌석");
        for(int i=1; i<=map.size(); i++){
            if(map.get(i)[0].equals("")) System.out.print("□ ");
            else System.out.print("■ ");
            if(i % 10 == 0) System.out.println();
        }
    }
}
