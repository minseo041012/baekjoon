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
        //n이 3일 경우로 가정해서 설명
        //우측 타일은 세로 직사각형 or 가로 직사각형으로 끝나는 방식
        //n - 1에서 세로 직사각형을 붙이고, n - 2에서 가로 직사각형을 붙이면 총 n의 개수가 나타남
        for(int i = 4; i <= n; i++)
            num_method[i] = (num_method[i - 1] + num_method[i - 2]) % 10007;

        bw.write(String.valueOf(num_method[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
