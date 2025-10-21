import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        boolean[] check = new boolean[10001];

        //1~10000까지 반복문으로 전부 돌면서 셀프 넘버인지 아닌지 판별
        for(int i = 1; i < 10001; i++){
            int temp = i;
            int temp_i = i;
            //각 수의 생성자 판별
            for(int j = 0; j <= i / 10; j++){
                temp += (temp_i % 10);
                temp_i /= 10;
            }
            //생성자일 경우, true로 변경
            if(temp < 10001)
                check[temp] = true;
        }

        //셀프 넘버만 출력
        for(int i = 1; i < 10001; i++){
            if(!check[i])
                sb.append(i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}