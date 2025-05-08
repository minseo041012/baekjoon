import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] person = new int[n + 1][2];
        int[] num = new int[n];
        
        //입력 값 배열에 저장
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i][0] = Integer.parseInt(st.nextToken());
            person[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(i != j){
                    //다 큰 경우
                    if(person[i][0] < person[j][0] && person[i][1] < person[j][1])
                        count++;
                }
            }
            if(count == 0)
                bw.write(String.valueOf(1) + " ");
            else
                bw.write(String.valueOf(count + 1) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}