import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] num = new int[n + 1];
        int[] sum = new int[n + 1];//누적합 담는 배열
        
        //num배열에 n만큼 수 담기 + 누적합 담기
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            sum[i] = num[i] + sum[i - 1];
        }
        //구간 합 구한 방법
        //누적합을 이용해서 구함 -> end - (start - 1) 이러면 시간초과 없이 빠르게 해결 가능
        //처음에는 start ~ end까지 반복문을 돌려서 해결하려고 했는데 시간초과 발생
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int result = sum[end] - sum[start - 1];
            //sb.append(result + "\n")이것보다 아래가 더 빠르다고 해서 사용
            sb.append(result).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}