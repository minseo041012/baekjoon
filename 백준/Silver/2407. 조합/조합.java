import java.io.*;
import java.util.*;
import java.math.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        BigInteger result = combination(n, Math.min(m, n - m));
        bw.write(String.valueOf(result));

        bw.flush();
        br.close();
        bw.close();
    }
    static BigInteger arr[][] = new BigInteger[101][101];

    public static BigInteger combination(int n, int m) {

        //처음 시작할 때, arr는 null로 초기화 되어있기 때문에 null이면 재귀호출을 통해 값을 얻어냄.
        if (arr[n][m] == null) {
            if (m == 0 || m == n)
                return arr[n][m] = BigInteger.valueOf(1);
            //arr[n][m]에 값을 저장해주면서 메모리제이션 구현
            return arr[n][m] = combination(n - 1, m).add(combination(n - 1, m - 1));
        }
        return arr[n][m];
    }
}