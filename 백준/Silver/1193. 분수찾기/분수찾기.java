import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int layer;
        //반복문을 통해 몇 층인지 알아내기
        for(layer = 1;; layer++){
            int cal = layer * (layer + 1) / 2;
            if(n <= cal)
                break;
        }
        int sum = layer + 1;//분모 분자의 합
        int start = layer * (layer - 1) / 2;//각 층의 시작 인덱스

        //분모 오름차순
        if(layer % 2 == 1){
            for(int i = 1; start <= n; i++){
                start++;
                if(start == n)
                    sb.append(sum - i).append("/").append(i);
            }
        }
        //분모 내림차순
        else{
            for(int i = layer; start <= n; i--){
                start++;
                if(start == n)
                    sb.append(sum - i).append("/").append(i);
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}