import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] edge = new long[102];
        edge[1] = 1;
        edge[2] = 1;
        edge[3] = 1;
        for(int j = 4; j <= 100; j++)
            edge[j] = edge[j - 2] + edge[j - 3];

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(edge[m]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}