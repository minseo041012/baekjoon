import java.io.*;
import java.util.*;


public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        int month[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

        int sum = 0;
        //월별 날짜 누적합 구하기
        for(int i = 0; i< x - 1; i++)
            sum += month[i];
        sum += y-1;//마지막으로 요일 구하기
        
        bw.write(String.valueOf(day[sum % 7]));
        bw.flush();
        bw.close();
        br.close();
    }
}