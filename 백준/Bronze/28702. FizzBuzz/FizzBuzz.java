import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = new String[3];
        int temp = 0;
        for(int i = 0; i < 3; i++){
            str[i] = br.readLine();
            //숫자인지 판별하기
            boolean isNumeric = str[i].matches("[+-]?\\d*(\\.\\d+)?");
            if (isNumeric){
                temp = Integer.parseInt(str[i]) + (3 - i);
                break;
            }
        }

        if(temp % 3 == 0 && temp % 5 == 0)
            bw.write("FizzBuzz");
        else if (temp % 3 == 0)
            bw.write("Fizz");
        else if (temp % 5 == 0)
            bw.write("Buzz");
        else
            bw.write(String.valueOf(temp));

        bw.flush();
        bw.close();
        bw.close();
    }
}