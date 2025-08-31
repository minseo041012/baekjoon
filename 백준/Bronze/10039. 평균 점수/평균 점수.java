import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        
        for(int i = 0; i < 5; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp <= 40)
                sum += 40;
            else
                sum += temp;
        }

        sb.append(sum / 5);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}