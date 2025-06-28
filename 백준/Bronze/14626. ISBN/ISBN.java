import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = new String[13];
        int sum = 0;
        int temp = 0;
        int m = 0;
        str = br.readLine().split("");


        for(int i = 0; i < 13; i++){
            //훼손된 숫자일 경우 아래 부분 실행하지 않음
            if (str[i].equals("*")){
                temp = i % 2 == 0 ? 1 : 3;
                continue;
            }
            //mod 0이면 가중치 1
            if(i % 2 == 0)
                sum += Integer.parseInt(str[i]);
            //mod 1 이면 가중치 3
            else
                sum += (Integer.parseInt(str[i]) * 3);
        }

        for(int i = 0; i < 10; i++){
            if((sum + temp * i) % 10 == 0)
                m = i;
        }
        bw.write(String.valueOf(m));

        bw.flush();
        bw.close();
        br.close();
    }
}