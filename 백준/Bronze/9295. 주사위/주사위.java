import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j = 0; j < 2; j++)
                sum += Integer.parseInt(st.nextToken());
            sb.append("Case ").append(i + ": ").append(sum).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}