import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n + 1];
        int[] sum = new int[n + 1];

        //num = Integer.parseInt(br.readLine().split(""));
        //
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum[i] = num[i] + sum[i - 1];
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = sum[end] - sum[start - 1];

            sb.append(result).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}