import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n + 3];

        arr[2] = 1;
        arr[4] = 3;
        //점화식: f(n) = (n - 1) * f(n - 2)
        //n - 1은 한 컵을 고르고 그 컵과 짝지을 컵 선택하는 경우의 수
        //f(n - 2)는 남은 컵들을 짝짓는 방법
        for(int i = 6; i <= n; i+= 2){
            arr[i] = (arr[i - 2] * (i - 1) % 1000000007);
        }

        bw.write(String.valueOf(arr[n] % 1000000007));
        bw.flush();
        bw.close();
        br.close();
    }
}