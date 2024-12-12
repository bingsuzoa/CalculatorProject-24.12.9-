package calculator;

import java.io.*;

public class Input {
    KakaoCalculator cal = new KakaoCalculator();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int processInput(int N) throws IOException {
        switch(N){
            case 1 :
                System.out.println("숫자 연산자 숫자 형식 또는 숫자 형식으로 입력해주세요 예) 5 + 4 또는 5");
                String command = br.readLine();
                cal.calculate(command);
                break;
            case 2 :
                System.out.println("히스토리를 보여드리겠습니다.");
                cal.getList();
                break;
            case 3 :
                System.out.println("프로그램을 종료합니다.");
                break;
            default :
                System.out.println("잘못된 입력 형식입니다. 다시 입력하세요.");
                break;
        }
        return N;
    }
}