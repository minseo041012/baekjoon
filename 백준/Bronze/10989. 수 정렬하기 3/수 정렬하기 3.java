import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       StringBuilder sb = new StringBuilder();

        //입력 받고 배열 넣기
       int num = Integer.parseInt(br.readLine());
       int[] count = new int[10001];

       //counting sort 1 : count 배열에 입력 받은 인덱스 위치에 1씩 증가
       for(int i = 0; i < num; i++)
           count[Integer.parseInt(br.readLine())]++;

       for(int i = 1; i < 10001; i++){
           //count 배열 0이 될때까지 출력
           while (count[i] > 0){
                   bw.write(String.valueOf(i) + "\n");
                   count[i]--;
          }
       }

       bw.flush();
       bw.close();
       br.close();
    }
}
