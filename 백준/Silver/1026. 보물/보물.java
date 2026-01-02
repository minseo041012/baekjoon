import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int A[] = new int[n];
        int B[] = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        //A, B 배열 입력 받기
        for(int i = 0; i < n; i++){
            A[i] = Integer.parseInt(st1.nextToken());
            B[i] = Integer.parseInt(st2.nextToken());
        }
        //오름차순으로 모두 정렬
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        //큰 값 * 작은 값 이런식으로 하면 최솟값을 얻을 수 있다
        for(int i = 0; i < n; i++)
            sum += (A[i] * B[n - i - 1]);

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}