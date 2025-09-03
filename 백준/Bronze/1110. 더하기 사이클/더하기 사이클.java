import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cycle = 0;
        int num = Integer.parseInt(br.readLine());
        int[] n = new int[2];
        n[0] = num / 10;
        n[1] = num % 10;
        int a = -1;//초기값을 -1로 하면 입력 값에 대해 모두 방어 가능
        int b = -1;
        int dup_a = n[0];//변하는 값들을 저장할 변수
        int dup_b = n[1];

        while(n[0] != a || n[1] != b){
            a = dup_b;//이전 수의 일의 자리 수
            b = (dup_a + dup_b) % 10;//새로운 수의 일의 자리 수
            dup_a = a;
            dup_b = b;
            cycle++;
        }

        bw.write(String.valueOf(cycle));
        bw.flush();
        bw.close();
        br.close();
    }
}