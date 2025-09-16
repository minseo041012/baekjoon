import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), "//.", true);
        int count = 0;

        while(st.hasMoreTokens()){
            String token = st.nextToken();
            //.일 경우, 이전에 X의 개수에 맞춰 aaaa, bb 출력
            if(token.equals(".")){
                sb.append(".");
            }
            else{
                int length = token.length();
                String temp = "";
                if(length > 3) {
                    temp += "AAAA".repeat(length / 4);
                    length %= 4;
                }
                if(length % 2 == 0)
                    temp += ("BB".repeat(length / 2));
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