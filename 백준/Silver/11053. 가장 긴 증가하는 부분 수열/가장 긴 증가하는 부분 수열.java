import java.io.*;
import java.util.*;


public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];//입력 받은 거 저장할 배열
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i< n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[n];
        int max = 0;
        for(int i = 0; i < n; i++){
            dp[i] = 1;//초기 길이는 무조건 1로 설정
            for(int j = 0; j < n; j++){
                //값이 커진다면 dp 갱신
                if(arr[j] < arr[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        //최대 길이 찾아 max에 저장
        for(int i = 0; i <n; i++)
            max = Math.max(dp[i], max);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}