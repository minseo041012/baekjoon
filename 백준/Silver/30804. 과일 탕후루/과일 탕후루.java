import java.io.*;
import java.util.*;

public class Main{
    static int[] f_num;
    static int[] fruit;
    static int n;
    static int max = 1;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        f_num = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++)
            f_num[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= 8; i++){
            for(int j = i + 1; j <= 9; j++){
                find_max(i, j);
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
    static void find_max(int f1, int f2){
        fruit = new int[n + 1];
        for(int i = 1; i <= n; i++){
            if(f_num[i] == f1 || f_num[i] == f2)
                fruit[i] = fruit[i - 1] + 1;
        }
        for(int i = 1; i <= n; i++)
            max = Math.max(max, fruit[i]);
    }
}