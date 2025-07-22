import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        int[] num = new int[12];

        num[1] = 1;
        num[2] = 2;
        num[3] = 4;
        //5의 경우에서 설명해보자면, 4에서 +1을 하면 5가 되고, 3은 +2, 2는 +3
        //결론적으로
        //num[i - 1]은 1을 더하는 경우, num[i - 2]는 2를 더하는 경우, num[i - 3]은 3을 더하는 경우
        for(int i = 4; i < 11; i++)
            num[i] = num[i - 1] + num[i - 2] + num[i - 3];

        for(int i = 0; i < testcase; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(num[n]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}