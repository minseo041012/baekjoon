import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++)
            sb.append(i).append(". ").append(br.readLine()).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}