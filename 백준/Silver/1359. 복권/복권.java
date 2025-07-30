import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //이 문제는 조합을 이용해서 푸는 문제
        //적어도 k개 수 -> k 이상이라는 것
        //그러면 m에서 k개가 같기 + k가 m이 될때까지 같은 경우를 더하면 문제 해결된다
        //k 이상을 찾지 못해서 이 문제에서 헤맸다.
        double sum = 0;
        for(int i = k; i <= m; i++)
            sum += combination(n - m, m - i) * combination(m, i);
        double result = (double)sum / combination(n, m);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }


    public static double combination(int n, int r){
        int i = 1;
        int j = 1;

        while(r > 0){
            i *= n;
            j *= r;
            r--;
            n--;
        }

        return (double)i/j;
    }
}