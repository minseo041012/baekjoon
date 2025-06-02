import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] arr = new String[n][m];
        int min = 1000000000;
        String[] case1 = "BWBWBWBW".split("");
        String[] case2 = "WBWBWBWB".split("");

        //보드 입력 받기
        for(int j = 0; j < n; j++){
            arr[j] = br.readLine().split("");
        }


        for(int i = 0; i < n ; i++){
            //행이 8개가 안되면 탈출
            if (i + 7 == n)
                break;
            for(int j = 0; j < m; j++){
                //열이 8개가 안되면 탈출
                if (j + 7 == m)
                    break;
                int count1 = 0;
                int count2 = 0;
                //case1부터 시작하는 경우
                for(int k = i; k < 8 + i; k++){
                    int idex = 0;
                    for(int l = j; l < 8 + j; l++){
                        //"BWBWBWBW"인 경우
                        if((k - i) % 2 == 0){
                            if (!arr[k][l].equals(case1[idex]))
                                count1++;
                            if (!arr[k][l].equals(case2[idex]))
                                count2++;
                        }
                        //"WBWBWBWBWB"인 경우
                        if ((k - i) % 2 == 1){
                            if (!arr[k][l].equals(case2[idex]))
                                count1++;
                            if (!arr[k][l].equals(case1[idex]))
                                count2++;
                        }
                        idex++;
                    }
                }
                //최솟값 찾기
                int temp = Math.min(count1, count2);
                min = Math.min(temp, min);

            }
        }
        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
        br.close();
    }
}