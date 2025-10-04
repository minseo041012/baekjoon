import java.io.*;
import java.util.*;

public class Main{
    static int mod = 1000000007;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        long n = Integer.parseInt(br.readLine());

        long count1 = fibo1(n);
        
        //dp 방식은 배열 1, 2를 미리 선언해서 사용하기 때문에 n-2
        sb.append(count1 % mod).append(" ").append(n - 2);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static long fibo1(long n){
        int a = 1;//f(n-2)
        int b = 1;//f(n-1)
        int c;//임시 저장용 변수

        //dp 메모리 최적화 버전
        //코드 실행 횟수는 f(N)과 같다  -> if(n==1 || n==2)가 실행되는 횟수가 f(n)번
        for(int i = 3; i <= n; i++){
            c = b;
            b = (a + b) % mod;
            a = c;
        }
        return b;
    }
}