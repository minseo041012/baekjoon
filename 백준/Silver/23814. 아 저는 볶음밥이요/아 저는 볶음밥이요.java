import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long D = Long.parseLong(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long service_n = (D - (N % D)) % D; // 짜장 다음 세트까지 부족
        long service_m = (D - (M % D)) % D; // 짬뽕 다음 세트까지 부족

        // 후보들 중 '추가 세트 수' 최대를 만들면서, 그중 '쓴 인원'이 최소인 걸 고른다.
        long bestExtra = K / D;   // 아무것도 안 채움 (전부 볶음밥으로 D단위)
        long bestCost  = 0;       // 짜장/짬뽕에 투입한 인원

        // 짜장만 싸게 채우는 경우
        if (service_n > 0 && K >= service_n) {
            long extra = 1 + (K - service_n) / D;
            long cost  = service_n;
            if (extra > bestExtra || (extra == bestExtra && cost < bestCost)) {
                bestExtra = extra;
                bestCost  = cost;
            }
        }

        // 짬뽕만 싸게 채우는 경우
        if (service_m > 0 && K >= service_m) {
            long extra = 1 + (K - service_m) / D;
            long cost  = service_m;
            if (extra > bestExtra || (extra == bestExtra && cost < bestCost)) {
                bestExtra = extra;
                bestCost  = cost;
            }
        }

        // 둘 다 싸게 채우는 경우
        if (service_n > 0 && service_m > 0 && K >= service_n + service_m) {
            long extra = 2 + (K - service_n - service_m) / D;
            long cost  = service_n + service_m;
            if (extra > bestExtra || (extra == bestExtra && cost < bestCost)) {
                bestExtra = extra;
                bestCost  = cost;
            }
        }

        // 볶음밥 최대 개수 = K - (짜장/짬뽕에 실제로 쓴 인원)
        long friedMax = K - bestCost;
        bw.write(String.valueOf(friedMax));
        bw.flush();
    }
}
