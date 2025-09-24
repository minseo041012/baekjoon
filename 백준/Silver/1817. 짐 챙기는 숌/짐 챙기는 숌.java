import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int book = Integer.parseInt(st.nextToken());
        int max_weight = Integer.parseInt(st.nextToken());
        int box = 0;
        int sum = 0;

        //책이 한 권도 없는 경우 예외 처리
        if(book > 0)
            st = new StringTokenizer(br.readLine());

        for(int i = 0; i < book; i++){
            int weight = Integer.parseInt(st.nextToken());
            sum += weight;

            //무게를 초과하는 경우, 이전에 들어간 책만 박스에 넣기
            if(sum > max_weight){
                box++;
                sum = weight;
            }
            //무게가 딱 떨어지는 경우
            else if(sum == max_weight){
                box++;
                sum = 0;
            }
        }
        //마지막 박스에 책이 있는 경우
        if(sum > 0)
            box++;

        bw.write(String.valueOf(box));
        bw.flush();
        bw.close();
        br.close();
    }
}