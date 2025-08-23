import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] A = new int[2];//분자를 담는 배열
        int[] B = new int[2];//분모를 담는 배열

        for(int i = 0; i < 2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        long n = A[0] * B[1] + A[1] * B[0];
        long m = B[0] * B[1];
        long gcd = gcd(n, m);

        sb.append(n/ gcd).append(" ").append(m / gcd);
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    static long gcd(long a, long b){
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
}