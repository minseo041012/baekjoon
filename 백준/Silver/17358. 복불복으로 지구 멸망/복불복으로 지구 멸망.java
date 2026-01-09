import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n + 3];

        arr[2] = 1;
        arr[4] = 3;
        for(int i = 6; i <= n; i+= 2){
            arr[i] = (arr[i - 2] * (i - 1) % 1000000007);
        }

        bw.write(String.valueOf(arr[n] % 1000000007));
        bw.flush();
        bw.close();
        br.close();
    }
}