import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        // 1은 항상 K-세준수
        int count = 1;

        // 1) K 이하 소수 구하기 (에라토스테네스의 체)
        List<Integer> primes = new ArrayList<>();
        if (K >= 2) {
            boolean[] comp = new boolean[K + 1];
            for (int i = 2; i <= K; i++) {
                if (!comp[i]) {
                    primes.add(i);
                    if ((long) i * i <= K) {
                        for (int j = i * i; j <= K; j += i) comp[j] = true;
                    }
                }
            }
        }

        // 2) 2..N 각 수를 소수<=K로 최대한 나누어본 뒤 남는 값이 1이면 K-세준수
        for (int i = 2; i <= N; i++) {
            int x = i;
            for (int p : primes) {
                if (x % p == 0) {
                    while (x % p == 0) x /= p; // p 소인수 제거
                    if (x == 1) break;        // 다 나눠졌으면 종료
                }
                // 남은 x가 소수일 수 있으므로 sqrt 가지치기
                if ((long) p * p > x) {
                    if (x <= K) x = 1;       // 남은 소수도 K 이하면 OK
                    break;                   // x>K면 실패 상태로 종료
                }
            }
            if (x == 1) count++;
        }

        bw.write(Integer.toString(count));
        bw.flush();
    }
}
