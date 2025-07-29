import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int repeat = Integer.parseInt(br.readLine());

        for(int i = 0; i < repeat; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            //static은 객체 생성 없이 이름만으로 직접 호출 가능함
            long result = Combination.combination(Math.max(n, m), Math.min(n, m));
            //append 따로 하는게 시간 절약된다고 함
            sb.append(result).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
//dp를 사용해서 조합 문제 해결하기
class Combination{
    static long[][] dp = new long[31][31];//메모리제이션할 배열

    public static long combination(int n, int m){
        //m이 1 또는 n이랑 같은 경우 1 리턴
        if(n == m || m == 0)
            return dp[n][m] = 1;
        //이미 값이 있는 경우는 값 리턴
        if(dp[n][m] != 0)
            return dp[n][m];
        dp[n][m] = combination(n - 1, m - 1) + combination(n - 1, m);
        return dp[n][m];
    }
}