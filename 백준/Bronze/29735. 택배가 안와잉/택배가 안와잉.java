import java.io.*;
import java.util.*;


public class Main{
    public static void main(String arsgs[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), ": ");

        int hour_start = Integer.parseInt(st.nextToken());//시작 시간
        int minute_start = Integer.parseInt(st.nextToken());
        int hour_end = Integer.parseInt(st.nextToken());//마감 시간
        int minute_end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());//브실이 택배 이전 보내야할 택배
        int mt = Integer.parseInt(st.nextToken());//배달 한 건에 걸리는 시간

        int day = 0;//며칠 걸리는지
        int hour_fin = hour_start;//도착 시간
        int minute_fin = minute_start;

        for(int i = 0; i <= count; i++){
            minute_fin += mt;

            //60분 이상인 경우 시간 올리기
            if(minute_fin >= 60){
                hour_fin++;
                minute_fin -= 60;
            }
            //택배가 마감시간 이후에 도착할 경우 다음날 배송
            if(hour_fin > hour_end || (hour_fin == hour_end && minute_fin >= minute_end)){
                i--;//배송 안했으니 하나 빼기
                hour_fin = hour_start;//다음날 배송 시작 시간으로 설정
                minute_fin = minute_start;
                day++;
                continue;
            }
        }

        sb.append(day).append("\n");
        sb.append(hour_fin / 10 >= 1 ? hour_fin : "0" + hour_fin).append(":").append(minute_fin / 10 >= 1 ? minute_fin : "0" + minute_fin).append("\n");
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}