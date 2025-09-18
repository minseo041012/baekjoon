import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int repeat = Integer.parseInt(br.readLine());
        int start = 1;
        int count = 0;

        for(int i = 0; i < repeat; i++){
            int section = Integer.parseInt(br.readLine());
            while(true){
                //구역 안에 해당하는 경우 반복문 탈출
                if(start <= section && section < start + m)
                    break;
                //가고자 하는 구역이 현재 구역보다 범위가 클 경우
                else if(section >= start + m)
                    start++;
                //가고자 하는 구역이 현재 구역보다 범위가 작을 경우
                else
                    start--;
                count++;
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}