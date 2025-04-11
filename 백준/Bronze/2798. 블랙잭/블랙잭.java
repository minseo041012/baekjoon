import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        //배열에 숫자 입력
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0;
        //숫자 3개를 고르는 것이기 때문에 3중 반복문 사용
        for(int i = 0; i < n; i++) {
            for (int j = i+ 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int count = arr[i] + arr[j] + arr[k];
                    if(count > sum && count <= m)
                        sum = count;
                }
            }
        }
        bw.write(String.valueOf(sum) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}