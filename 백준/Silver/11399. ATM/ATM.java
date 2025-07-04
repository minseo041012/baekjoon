import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr;
        int[] m = new int[n];
        int sum = 0;
        int temp = 0;
        //문자열을 " " 기준으로 나누기
        arr = br.readLine().split(" ");
        //string -> int
        for(int i = 0; i < n; i++)
            m[i] = Integer.parseInt(arr[i]);
        //오름차순으로 정렬
        Arrays.sort(m);
        //누적합 이용해서 sum에 더해주기
        for(int i = 0; i < n; i++){
            temp += m[i];
            sum += temp;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}