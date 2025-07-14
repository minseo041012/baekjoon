import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int amount = Integer.parseInt(st.nextToken());
        int[] coin = new int[num];
        int count = 0;
        
        //동전의 개수 coin 배열에 저장
        for(int i = 0; i < num; i++)
            coin[i] = Integer.parseInt(br.readLine());

        //큰 금액부터 계산하면서 최솟값 구하기
        for(int i = num - 1; i >= 0; i--){
            //잔액이 0이면 중도 탈출
            if (amount == 0)
                break;
            //몫이 0보다 큰 경우, amount가 나누어진다는 사실
            if (amount / coin[i] > 0){
                count += amount / coin[i];
                amount %= coin[i];
            }
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}