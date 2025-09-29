import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());//곡의 개수
        int l = Integer.parseInt(st.nextToken());//곡의 길이
        int d = Integer.parseInt(st.nextToken());//전화벨 울리는 시간
        int dup_d = d;
        int time = 0;
        int listen = 0;

        //노래는 0초부터 시작하기 때문에 0~ l-1초까지 재생
        //l ~ l + 4까지는 노래가 들리지 않음
        //위 구간안에 벨소리가 1초라도 울려야한다
        loop:
        for(int i = 0; i < n; i++){
            time += l;//곡 재생되는 시간
            //늘어난 벨소리 텀 관리
            if(time > d)
                d = ((int)Math.ceil((double)time / dup_d)) * dup_d;
            //노래와 노래 사이 공백 5초 구간
            if(time <= d && d < time + 5) {
                listen = d;
                break;
            }
            time += 5;//공백 5초 더해주기
        }
        //곡이 다 끝나고 전화벨을 듣는 경우
        if(listen == 0)
            listen = d;

        bw.write(String.valueOf(listen));
        bw.flush();
        bw.close();
        br.close();
    }
}