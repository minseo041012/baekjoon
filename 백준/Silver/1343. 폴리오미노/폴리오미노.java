import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //구분자를 "."로, 3번째 인자를 true로 주면서 토큰으로도 지정
        StringTokenizer st = new StringTokenizer(br.readLine(), "//.", true);
        int count = 0;

        while(st.hasMoreTokens()){
            String token = st.nextToken();
            //.일 경우
            if(token.equals(".")){
                sb.append(".");
            }
            else{
                int length = token.length();
                String temp = "";
                //사전순으로 출력해야함으로, AAAA 먼저 검사
                if(length > 3) {
                    temp += "AAAA".repeat(length / 4);
                    length %= 4;
                }
                if(length % 2 == 0)
                    temp += ("BB".repeat(length / 2));
                //홀수인 경우는 A or B로 덮을 수 없기에 -1 출력
                else{
                    sb.setLength(0);
                    sb.append("-1");
                    break;
                }
                sb.append(temp);
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}