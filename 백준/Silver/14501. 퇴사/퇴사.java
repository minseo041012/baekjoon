import java.io.*;
import java.util.*;


/**
 * 이 문제가 삼성 역량 기출문제라고 하는데 모르겠고 개어렵다...
 * dp를 이용해서 푸는 문제라고 하는데 계속계속 봐도 이게 dp로 푸는 게 맞는지도 감이 안잡히더라 공부를 더 해야하는 신호겠지
 * 점화식은 dp[i + income[i][0]] = Math.max(dp[i + income[i][0]], dp[i] + income[i][1]);
 * 이런 식은 어떻게 생각해내는건지 진짜 신기하고요. 공부량이 적다는 신호겠지... 공부를 해야겠지*/
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //step 1
        int day = Integer.parseInt(br.readLine());
        int[][] income = new int[day][2];

        for(int i = 0; i < day; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            income[i][0] = Integer.parseInt(st.nextToken());
            income[i][1] = Integer.parseInt(st.nextToken());
        }

        //step 2
        int dp[] = new int[day + 1];

        for(int i = 0; i < day; i++) {
            //퇴사일자를 넘어서는 안된다
            //상담을 하는 경우
            if(i + income[i][0] <= day)
                //현재까지 그날 받을 수 있다고 계산된 돈, 오늘 상담을 새로 해서 그날 받게 될 돈 중 큰 값 선택
                dp[i + income[i][0]] = Math.max(dp[i + income[i][0]], dp[i] + income[i][1]);
            //상담을 안 하거나, 이전까지의 최댓값을 다음날로 넘기는 경우
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);//수익 이어가기
        }

        bw.write(String.valueOf(dp[day]));
        bw.flush();
        br.close();
        bw.close();
    }
}