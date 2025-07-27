import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //dp를 이용해 풀기 위한 배열
        int[] arr = new int[n + 3];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i = 4; i <= n; i++){
            int min = 4;
            double sqrt = Math.sqrt(i);
            //루트 n이 정수로 떨어질 경우
            if(sqrt == (int)sqrt) {
                arr[i] = 1;
                continue;
            }
            //점화식은 dp[i] = dp[i -j*j] + dp[j*j]
            //이때, dp[j*j]는 1 고정 값이기 때문에 +1
            //아래는 이해를 돕기 위한 예시
            //dp[5] = dp[2*2] + dp[1]
            //dp[6] = dp[2*2] + dp[2]
            //dp[7] = dp[2*2] + dp[3]
            for(int j = (int)Math.sqrt(i); j > 0; j--){
                min = Math.min(arr[i - j*j] + 1, min);
            }
            arr[i] = min;
        }
    

        bw.write(String.valueOf(arr[n]));

        bw.flush();
        bw.close();
        br.close();
    }
}