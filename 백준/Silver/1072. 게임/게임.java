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

        //100퍼센트 제외하고 이진탐색으로 count 얻기
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