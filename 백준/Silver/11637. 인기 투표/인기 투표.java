import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase; i++){
            int n = Integer.parseInt(br.readLine());
            int[] candidate = new int[n];
            int max = 0;//최다 득표 수
            int sum = 0;
            int idex_winner = 0;//최다 득표자 인덱스

            for(int j = 0; j < n; j++){
                candidate[j] = Integer.parseInt(br.readLine());
                //최다 득표자일 경우
                if(max < candidate[j]) {
                    max = candidate[j];
                    idex_winner = j;
                }
                sum += candidate[j];
            }
            Arrays.sort(candidate);
            //최다 득표자가 1명 초과일 경우
            if(candidate[candidate.length - 1] == candidate[candidate.length - 2])
                sb.append("no winner").append("\n");
            //최다 득표자가 과반수 득표했을 경우
            else if(sum / 2 < candidate[candidate.length - 1])
                sb.append("majority winner ").append(idex_winner + 1).append("\n");
            //절반 이하의 득표를 했을 경우
            else
                sb.append("minority winner ").append(idex_winner + 1).append("\n");

        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}