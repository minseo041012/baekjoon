import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        long num;

        for(int i = 0; i < n; i++) {
            num = Long.parseLong(br.readLine());
            //크거나 같은 소수 찾는 반복문
            for(;;){
                //소수가 맞다면 break
                if(prime(num)) {
                    sb.append(num).append("\n");
                    break;
                }
                //1씩 증가시키면서 다음 수가 소수인지 확인
                else
                    num++;
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean prime(long num){
        if(num < 2)
            return false;
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}