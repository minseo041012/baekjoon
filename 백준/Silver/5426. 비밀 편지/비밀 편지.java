import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for(int ii = 0; ii < testcase; ii++){
            String s = br.readLine();
            int len = (int)Math.sqrt(s.length());
            String[][] arr = new String[len][len];
            int count = 0;

            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++) {
                    arr[i][j] = s.substring(count, count+1);
                    count++;
                }
            }
            for(int i = 0; i < len; i++){
                for(int j = 0; j < len; j++)
                    sb.append(arr[j][len - i - 1]);
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}