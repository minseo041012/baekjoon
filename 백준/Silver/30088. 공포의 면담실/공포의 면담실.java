import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int department = Integer.parseInt(br.readLine());
        int[] sum = new int[department];
        long result = 0;

        for(int i = 0; i < department; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int employee = Integer.parseInt(st.nextToken());
            for(int j = 0; j < employee; j++)
                sum[i] += Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sum);

        long temp = 0;
        for(int i = 0; i < department; i++){
            temp += sum[i];
            result += temp;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}