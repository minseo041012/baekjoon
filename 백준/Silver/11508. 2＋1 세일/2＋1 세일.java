import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int min = 0;

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);//오름차순으로 정렬
        //i 가격이 큰 순서부터 차례대로 2 + 1 시전, j 3번쩨는 제외하고 다 더해줄 용도
        for(int i = n - 1, j = 1; i >=0 ; i--, j++){
            if(j % 3 != 0)
                min += arr[i];
        }

        bw.write(String.valueOf(min));
        bw.flush();
        br.close();
        bw.close();
    }
}