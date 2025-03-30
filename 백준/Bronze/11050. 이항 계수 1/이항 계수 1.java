import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int result = 1;

        //만약 n - m < m 이 크면 계산 회수 줄이기
        if ( n - m < m)
            m = n -m;
        for(int i = 0; i < m; i++)
            result *= (n - i);
        for(int i = 0; i < m - 1; i++)
            result /= (m - i);
        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}