import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int count = 0;

        

        while(true){
            int sum = 0;
            //num이 일의 자리 수일 경우
            if(s.length() == 1){
                break;
            }
            //입력된 값의 총 합 구하기
            for(int i = 0; i < s.length(); i++){
                sum += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            s = String.valueOf(sum);
            count++;
        }

        //3의 배수이면 횟수와 yes 출력
        if(Integer.parseInt(String.valueOf(s)) % 3 == 0)
            sb.append(count).append("\n").append("YES");
        //3의 배수가 아니면 no 출력
        else
            sb.append(count).append("\n").append("NO");
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();
    }
}