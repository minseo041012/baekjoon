import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int temp = A;//나머지 임시 저장
        int count = 0;//소수점 임시 저장

        for(int i = 0;; i++){
            count = temp / B;
            temp -= count * B;
            temp *= 10;
            //소수점 N번까지 왔으면 출력
            if(i == N){
                bw.write(String.valueOf(count));
                break;
            }
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}