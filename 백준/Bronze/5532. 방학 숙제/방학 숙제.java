import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int day = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        int temp1 = A / C;
        int temp2 = B / D;

        if(A % C > 0 )
            temp1++;
        if(B % D > 0)
            temp2++;

        bw.write(String.valueOf(day - Math.max(temp1, temp2)));
        bw.flush();
        bw.close();
        br.close();
    }
}