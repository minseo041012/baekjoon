import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] arr = new int[15][15];
        int result = 0;
        //0번쨰 배열에 i 채워주기
        for(int i = 0; i < 15; i++)
            arr[0][i] = i;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int k = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());
            //출력할 결과 값
            result = 0;
            //0번쨰 층부터 k-1까지 돌기
            for(int a = 0; a < k; a++){
                //a번째 사람 숫자
                int count = 0;
                //1부터 m까지 돌기
                for(int b = 1; b <= m; b++) {
                    //0번째는 위에서 채워줌
                    if (a != 0){
                        count += arr[a - 1][b];
                        arr[a][b] = count;
                    }
                    //k-1번째부터 더해주면 끝
                    if (a == k - 1)
                        result += arr[a][b];
                }
            }

            bw.write(String.valueOf(result) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
