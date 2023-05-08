/*
회원가입 & 로그인 프로그램
 */
package app.syr.project4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> members = new HashMap<>();
        init(members);

        System.out.println("========= 프로그램 시작 =========");
        String answer;

        while(true){
            System.out.println("원하는 작업을 선택해주세요. (1) 로그인 / (2) 회원가입 / (0) 프로그램 종료");
            answer = br.readLine();

            if(answer.equals("0")) break;
            else if(answer.equals("1")){
                login(br, members);
            } else if(answer.equals("2")) {
                join(br, members);
            } else System.out.println("올바른 숫자를 입력해주세요.");
        }

        System.out.println("========= 프로그램 종료 =========");

        br.close();
    }

    private static void init(Map<String, String> members){
        members.put("admin", "admin1234");
    }

    private static String login(BufferedReader br, Map<String, String> members) throws IOException {
        System.out.println("========== 로그인 ==========");
        String id; String pw;
        while(true){
            System.out.print("아이디 : ");
            id = br.readLine();
            if(members.get(id) == null) System.out.println("아이디를 다시 입력해주세요.");
            else break;
        }
        while(true){
            System.out.print("비밀번호 : ");
            pw = br.readLine();
            if(!members.get(id).equals(pw)) System.out.println("비밀번호를 다시 입력해주세요.");
            else break;
        }
        System.out.println("%s 님이 로그인하셨습니다.".formatted(id));
        System.out.println("=".repeat(20));
        return id;
    }

    private static String join(BufferedReader br, Map<String, String> members) throws IOException {
        System.out.println("========== 회원가입 ==========");
        String id; String pw1; String pw2;
        while(true){
            System.out.println("아이디는 4자 이상 20자 이하, 영문 및 숫자로 구성되어야 합니다.");
            System.out.print("아이디 : ");
            id = br.readLine();
            if(id.matches("[a-zA-Z0-9]+") && id.length() >= 4 && id.length() <= 20){
                if(members.get(id) != null) {
                    System.out.println("이미 존재하는 아이디입니다.");
                } else break;
            }
        }
        while(true){
            System.out.println("비밀번호는 6자 이상 20자 이하, 영문 및 숫자로 구성되어야 합니다.");
            System.out.print("비밀번호 : ");
            pw1 = br.readLine();
            if(pw1.matches("[a-zA-Z0-9]+") && pw1.length() >= 6 && pw1.length() <= 20){
                break;
            }
        }
        System.out.println("비밀번호를 한 번 더 입력해주세요.");
        while(true){
            System.out.print("비밀번호 확인 : ");
            pw2 = br.readLine();
            if(!pw1.equals(pw2)) System.out.println("비밀번호가 일치하지 않습니다.");
            else break;
        }
        members.put(id, pw1);
        System.out.println("%s 님의 회원가입이 완료되었습니다.".formatted(id));
        System.out.println("=".repeat(20));
        return id;
    }
}
