import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long result = 0;
        long num = (long) (Math.log10(n) + 1);//몇의 자리 숫자인지 확인하는 변수


        for(long i = 0; i < num; i++){
            //각 범위에 따라 자리 수 곱해주는 식
            //10~99면 90 * 2, 100~999면 900 * 3
            if(n >= Math.pow(10, i + 1))
                result += (i + 1) * 9 * (long)Math.pow(10, i);
            else {
                n -= (long)Math.pow(10, i);//나머지 값을 구한 후
                result += (n + 1) * (i + 1);//n+1인 이유는 xx0, x0 처럼 일의 자리가 0인 경우 고려
                break;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}