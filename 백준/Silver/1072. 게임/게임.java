import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());
        long count = 0;//최소 몇 판 더 해야하는 지 적을 변수

        double z = Math.floor((double)y * 100 / x);//처음 승률

        //99퍼이면, 이미 패배 전적이 있기 때문에 100으로 올라갈 수 없다.
        if(z <= 98)
            count = binary(0, x, x, y, z);

        if(count == 0)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static long binary(long left, long right, long x, long y, double z){
        while(left <= right){
            long mid = (left + right) / 2;
            //y/x*100 대신 아래처럼 사용한 이유
            //처음에 y * 100을 곱함으로써, 소수점 계산에서 발생되는 오차를 피할 수 있다.
            long temp_per = ((mid + y) * 100) / (x + mid);

            //승률이 1보다 크면 right 변경
            if(temp_per - z >= 1)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}