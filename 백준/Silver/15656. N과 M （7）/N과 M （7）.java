import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int current = 0;
    static int[] check;
    static int n, m;
    static int[] arr;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        check = new int[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);//입력 받은 수 오름차순으로 정렬

        backtracking(0,0);
        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }

    static void backtracking(int cur, int de){
        //깊이가 m에 도달하면 줄바꿈
        if(de == m) {
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n; i++){
            check[cur] = arr[i];
            //cur이 0보다 클 경우, 이전에 나온 수 적어주는 작업
            if(cur != 0 && i != 0) {
                for (int j = 0; j < cur; j++)
                    sb.append(check[j]).append(" ");
            }
            sb.append(check[cur]).append(" ");
            backtracking(cur + 1, de + 1);
        }
    }
}