import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n + 1][31];

        //점화식: dp[i][j] = dp[i][j] = dp[i-1][j -1] + dp[i - 1][j]
        //이때 i는 row
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= i; j++){
                //행의 양 끝 값은 1로 설정
                if(j == 1 || j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j -1] + dp[i - 1][j];
            }
        }

        bw.write(String.valueOf(dp[n][k]));
        bw.flush();
        bw.close();
        br.close();
    }
}