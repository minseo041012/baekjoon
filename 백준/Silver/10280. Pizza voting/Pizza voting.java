import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int fav = Integer.parseInt(st.nextToken()); // 1-indexed

        // 입력은 소모만 (칼로리/이름은 로직에 불필요)
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); // calories
            st.nextToken(); // name (one word)
        }

        int L = 1, R = n;
        int turn = 1;              // 1: Alice(오른쪽), 2: Bob(왼쪽), 0: Me
        boolean decided = false;   // 출력 확정 여부

        while (L < R) {
            if (turn % 3 == 1) { // Alice: 오른쪽 제거
                if (R == fav) { bw.write("NO"); decided = true; break; }
                R--;
            } else if (turn % 3 == 2) { // Bob: 왼쪽 제거
                if (L == fav) { bw.write("NO"); decided = true; break; }
                L++;
            } else { // Me: 한쪽 선택
                int len = R - L + 1;

                if (fav == L) {               // fav가 왼쪽 끝
                    if (len <= 3) { R--; }    // 반대쪽(오른쪽) 제거해서 바로/곧바로 승리
                    else { bw.write("NO"); decided = true; break; }
                } else if (fav == R) {        // fav가 오른쪽 끝
                    if (len <= 3) { L++; }    // 반대쪽(왼쪽) 제거
                    else { bw.write("NO"); decided = true; break; }
                } else { // fav가 가운데
                    if (len == 3) {
                        // [L, fav, R] 형태 → 왼쪽을 지우면 Alice가 오른쪽 지워서 fav만 남음
                        L++;
                    } else { // len >= 4
                        if (fav == L + 1) {
                            // 왼쪽 지우면 다음 Bob이 fav 제거 → 오른쪽을 지움
                            R--;
                        } else if (fav == R - 1) {
                            // 오른쪽 지우면 다음 Alice가 fav 제거 → 왼쪽을 지움
                            L++;
                        } else {
                            // 여유가 있으니 더 먼 쪽을 줄여 균형 유지
                            int leftGap = fav - L;
                            int rightGap = R - fav;
                            if (rightGap >= leftGap) R--;
                            else L++;
                        }
                    }
                }
            }
            turn++;
        }

        if (!decided) {
            bw.write((L == R && L == fav) ? "YES" : "NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
