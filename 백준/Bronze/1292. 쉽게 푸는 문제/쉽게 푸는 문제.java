import java.io.*;
import java.util.*;


public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[b + 1];
        int sum = 0;//구간의 합 저장
        int start = 1;//시작 구간
        int end = 1;//끝 구간

        loop:
        for(int i = 1; i <= b; i++){
            for(int j = start; j <= end; j++) {
                arr[j] = i;
                //이중반복문 탈출
                if(j == b)
                    break loop;
            }
            start += i;
            end += (i + 1);
        }

        //해당 구간에 해당하는 수열 합하기
        for(int i = a; i <= b; i++)
            sum += arr[i];

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}