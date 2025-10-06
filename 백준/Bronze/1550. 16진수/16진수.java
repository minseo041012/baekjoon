import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split("");
        String[] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int sum = 0;

        for(int i = 0; i <arr.length; i++){
            //index를 통해 0~15 중 매칭되는 hex 찾기
            for(int j = 0; j < 16; j++){
                if(hex[j].equals(arr[i])) {
                    //16진수 계산법: 16^i 씩 곱해주기
                    sum += j * (int)Math.pow(16, arr.length - 1 - i);
                    break;
                }
            }
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}