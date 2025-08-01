import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int round = 0;

        while(hansu != jimin){
            hansu = hansu / 2 + hansu % 2;
            jimin = jimin / 2 + jimin % 2;
            round++;
        }
        bw.write(String.valueOf(round));

        bw.flush();
        bw.close();
        br.close();
    }
}