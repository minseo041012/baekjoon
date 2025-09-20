import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][4];

        //case 1~3로 나눌 수 있다
        //case 1: N번째 배치 x -> N-1번째 배치x, 좌측 하나 배치, 우측 하나 배치
        //case 2: N번째 오른쪽 배치 ->  N-1번째 배치x, 좌측 하나 배치
        //case 3: N번째 왼쪽 배치 -> N-1번째 배치x, 우측 하나 배치
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;


        //점화식
        //dp[n][1] = dp[n-1][1] + dp[n-1][2] + dp[n-1][3]
        //dp[n][2] = dp[n-1][1] + dp[n-1][3]
        //dp[n][3] = dp[n-1][1] + dp[n-1][2]
        for(int i = 2; i <= n; i++){
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 9901;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3]) % 9901;
            dp[i][3] = (dp[i - 1][1] + dp[i - 1][2]) % 9901;
        }

        long result = (dp[n][1] + dp[n][2] + dp[n][3]) % 9901;

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }
}