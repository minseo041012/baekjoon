import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String[] arr = br.readLine().split("");//입력된 문자열 담는 배열
            String[] redun = new String[arr.length];//redundancy 담는 배열
            int point = 0;
            for(int j = 0; j < arr.length; j++){
                //처음은 무조건 넣기
                if(j == 0)
                    redun[point] = arr[j];
                //이전에 있는 문자와 다른 문자열일 떄만 넣기
                else if(!arr[j].equals(redun[point])){
                    point++;
                    redun[point] = arr[j];
                }
            }
            //null이 아닐떄까지 출력
            for(int j = 0; j < redun.length && redun[j] != null; j++)
                sb.append(redun[j]);
            sb.append("\n");
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}