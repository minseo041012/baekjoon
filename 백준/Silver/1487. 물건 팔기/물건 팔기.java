import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int person = Integer.parseInt(br.readLine());
        int[][] fee = new int[person][2];
        int result = 0;
        int max = 0;

        //지불 용의, 배송비 입력
        for(int i = 0; i < person; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            fee[i][0] = Integer.parseInt(st.nextToken());
            fee[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(fee, Comparator.comparing((int[] o) -> o[0]));//지불 용의 가격을 오름차순으로 정렬

        for(int i = 0; i < person; i++){
            int temp = fee[i][0];
            int max_temp = 0;
            //현재 가격(temp)으로 팔았을 경우, 이익 더하기(판매가 - 배송비)
            for(int j = i; j < person; j++){
                //판매가 - 배송비가 0보다 클 경우
                if((temp - fee[j][1]) > 0)
                    max_temp += (temp - fee[j][1]);
            }
            //이익이 크거나 이익이 같을 경우는 더 적은 가격으로 판매
            if(max_temp > max) {
                result = temp;
                max = max_temp;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}