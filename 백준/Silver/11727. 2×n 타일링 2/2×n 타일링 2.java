import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] num_square = new long[n + 2];

        num_square[1] = 1;
        num_square[2] = 3;

        //문제풀이
        //n - 1에서는, 2*1 타일 붙여 2*n 구할 수 있음
        //n - 2에서는, 1*2 타일 2개를 붙이거나, 2*2 타일을 붙여 2*n 구할 수 있다
        //그렇기에 n - 2에서는 *2를 해준다
        for(int i = 3; i <= n; i++)
            num_square[i] = (num_square[i - 1] + num_square[i - 2] * 2) % 10007;
        bw.write(String.valueOf(num_square[n]));

        bw.flush();
        bw.close();
        br.close();
    }
}