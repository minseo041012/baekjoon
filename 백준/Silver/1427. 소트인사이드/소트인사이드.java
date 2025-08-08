import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //수를 문자열로 받아서 배열에 저장
        String[] s = br.readLine().split("");
        Arrays.sort(s);//먼저 오름차순으로 정렬

        //내림차순으로 출력해야하니 뒤에서부터 시작한다
        for(int i = s.length - 1; i >= 0; i--)
            sb.append(s[i]);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}