import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 3];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i = 4; i <= n; i++){
            int min = 4;
            double sqrt = Math.sqrt(i);
            //루트 n이 정수로 떨어질 경우
            if(sqrt == (int)sqrt) {
                arr[i] = 1;
                continue;
            }
            //
            for(int j = (int)Math.sqrt(i); j > 0; j--){
                min = Math.min(arr[i - j*j] + 1, min);
            }
            arr[i] = min;
        }


        bw.write(String.valueOf(arr[n]));

        bw.flush();
        bw.close();
        br.close();
    }
}