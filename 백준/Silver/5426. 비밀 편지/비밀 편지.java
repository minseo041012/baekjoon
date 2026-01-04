import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for(int ii = 0; ii < testcase; ii++){
            String s = br.readLine();
            int len = (int)Math.sqrt(s.length());

            //반시계 방향으로 문자 이동 시
            //(i, j) -> (len - j, i)
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++)
                    sb.append(s.charAt(j * len + (len-i-1)));
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}