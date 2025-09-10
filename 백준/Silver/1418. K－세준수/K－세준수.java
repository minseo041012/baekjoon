import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] largest = new int[N + 1];
        int count = 0;

        for (int i = 2; i <= N; i++) {
            if (largest[i] == 0) {  // i는 소수
                for (int j = i; j <= N; j += i) {
                    largest[j] = i;  // j의 소인수 중 i가 가장 큰 소인수로 갱신됨
                }
            }
        }

        // 1은 항상 K-세준수
        count = 1;
        for (int i = 2; i <= N; i++) {
            if (largest[i] <= K) count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
    }
}
