import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result = series_num(n);

        bw.write(String.valueOf(result));

        bw.flush();
        bw.close();
        br.close();
    }

    public static int series_num(int n){
        int num = 666;
        int count = 0;
        String s;

        while(true){
            s = Integer.toString(num);
            //숫자 안에 666이 존재한다면 count 1증가
            if(s.contains("666"))
                count++;
            //count값이 n과 같아진다면 num return 
            if(count == n)
                return num;
            num++;
        }
    }
}