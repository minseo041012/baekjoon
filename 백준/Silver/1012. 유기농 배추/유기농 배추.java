import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static int n, m;
    static int dx[] = {0, 0, -1, 1};//x축으로 상하좌우 표현
    static int dy[] = {1, -1, 0, 0};//y축으로 상하좌우 표현
    static boolean[][] visited;


    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());//testcase

        for(int t = 0; t < repeat; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            visited = new boolean[m][n];
            int count = 0;

            int napa_cabbage = Integer.parseInt(st.nextToken());

            //배추가 심어준 위치를 1로 표시
            for(int i = 0; i < napa_cabbage; i++){
                st = new StringTokenizer(br.readLine());
                int weight = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());

                arr[weight][height] = 1;
            }
            //각 위치마다 순회하면서 dfs 시작
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        DFS(i, j);  // 이 호출 한 번이 '지렁이 1마리'에 해당
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int x, int y){
        //범위 초과
        if(x < 0 || y < 0 || x >= m || y >= n)
            return;
        //배추가 없는 곳
        if(arr[x][y] == 0 || visited[x][y])
            return;
        visited[x][y] = true;
        //배추가 있을 경우
        if(arr[x][y] == 1) {
            arr[x][y] = 0;
            //상하좌우에 있는 배추 확인하기
            for(int ii = 0; ii < 4; ii++)
                DFS(x + dx[ii], y + dy[ii]);
        }
    }
}