import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] sum = new int[n + 1];
        long ans = 0;

        //정삼각형의 개수를 sum 배열에 저장
        for(int i = 1; i <= n; i++)
            sum[i] = sum[i - 1] + i;

        //정삼각형의 개수
        for(int i = 1; i <= n; i++)
            ans += sum[i];

        //역삼각형의 개수
        //sum[i + 2] 범위는 i = 1~N-1
        for(int i = n - 1; i > 0; i-=2)
            ans += sum[i];


        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}