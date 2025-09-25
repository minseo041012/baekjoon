import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        //모든 n >= n0에 대해여, g(n)이 f(n)보다 크거나 같아야 한다
        //둘 다 1차함수로 생각하면 f(n) 기울기 n가 g(n)의 기울기 c보다 크게되면 언젠가 f(n)이 커질 수 밖에 없다
        //그러므로 기울기는 c >= a가 되어야 한다
        if(n * n0 + m <= c * n0 && c >= n)
            bw.write(String.valueOf("1"));
        else
            bw.write(String.valueOf("0"));

        bw.flush();
        bw.close();
        br.close();
    }
}