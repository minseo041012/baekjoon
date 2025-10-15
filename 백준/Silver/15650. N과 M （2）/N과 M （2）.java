import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;
    static boolean[] visit;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visit = new boolean[n + 1];

        backtracking(0, 0);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }


    static void backtracking(int depth, int cur){
        //m까지 도달하면 저장된 값 출력 후 줄바꿈
        if(depth == m){
            for(int a: arr) sb.append(a).append(" ");
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            //이미 방문을 한 경우
            if(visit[i])
                continue;
            //방문하지 않은 경우
            else if(cur < i && !visit[i]){
                visit[i] = true;
                arr[depth] = i;//중복 없는 수열 생성해야하기 떄문
                backtracking(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}