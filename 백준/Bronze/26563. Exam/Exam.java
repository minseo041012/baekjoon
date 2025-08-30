import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int repeat = 0; repeat < n; repeat++){
            int k = Integer.parseInt(br.readLine());
            String[] me = br.readLine().split("");
            String[] friend = br.readLine().split("");
            int diff = 0;
            int same = 0;

            int count = 0;
            for(int i = 0; i < me.length; i++){
                //서로 다른 답의 개수를 diff에 저장
               if(!me[i].equals(friend[i]))
                   diff++;
               //같은 경우 same에 저장
               else
                   same++;
            }

            //답이 같은 것 중에서 작은 것을 선택하고 다른 것 중에서도 다른 것을 선택해야 내가 맞출 수 있는 최적의 해 나옴
           count = Math.min(same, k) + Math.min(diff, me.length - k);
            sb.append(count).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}