import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] num_method = new long[n + 3];

        num_method[1] = 1;
        num_method[2] = 2;
        num_method[3] = 3;
        //n이
        for(int i = 4; i <= n; i++)
            num_method[i] = (num_method[i - 1] + num_method[i - 2]) % 10007;

        bw.write(String.valueOf(num_method[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}