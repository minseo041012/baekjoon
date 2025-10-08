import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int count = 1;

        //점수가 최소가 되려면 112233 이런 식으로 같은 숫자끼리 붙어있어야 한다
        //따라서 순열 사용시 바로 풀림
        //P!
        for(int i = 1; i <= n; i++)
            count *= i;

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}