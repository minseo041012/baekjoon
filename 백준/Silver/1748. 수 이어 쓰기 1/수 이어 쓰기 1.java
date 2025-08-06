import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long temp = n;
        long result = 0;
        long num = (long) (Math.log10(n) + 1);//몇의 자리 숫자인지 확인하는 변수


        for(long i = 0; i < num; i++){
            //각 범위에 따라 자리 수 곱해주는 식
            if(temp >= Math.pow(10, i + 1))
                result += (i + 1) * 9 * (long)Math.pow(10, i);
            else {
                n -= (long)Math.pow(10, i);
                result += (n + 1) * (i + 1);
                break;
            }
            //n -= 9 * (long)Math.pow(10, i);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}