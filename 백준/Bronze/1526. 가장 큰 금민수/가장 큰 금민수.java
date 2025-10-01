import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        //브루트포스 알고리즘
        for(int i = n; i > 0; i--){
            int result = i;
            boolean ans = true;
            //자릿수마다 4 7인지 확인하기
            for(int j = 0; j < (int)Math.log10(i) + 1; j++){
                //아닐 경우, ans를 false로 하고 탈출
                if(result % 10 != 4 && result % 10 != 7) {
                    ans = false;
                    break;
                }
                else
                    result /= 10;
            }
            //4 7로 이루어졌을 경우
            if(ans){
                bw.write(String.valueOf(i));
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}