import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String temp = "*";
        int n = Integer.parseInt(br.readLine());
        //문자열 반복할 수 있는 메소드
        //str.repeat(n) -> str은 반복 원하는 문자열, n은 원하는 반복 횟수
        for(int i = n; i > 0; i--)
            sb.append(temp.repeat(i)).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}