import java.io.*;
import java.util.*;

public class Main{
    static int n, m;
    static ArrayList<Integer> graph[];
    static int cpt =0;
    static boolean[] visited;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for(int i = 1; i <=  n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        //bfs로 연결요소 탐색
        for(int i = 1; i <= n; i++) {
            //방문하지 않은 요소만 확인
            if(!visited[i]) {
                bfs(i);
                cpt++;
            }
        }

        bw.write(String.valueOf(cpt));
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int num){
        Queue<Integer> qu = new LinkedList<>();//FIFO
        qu.offer(num);
        visited[num] = true;

        while(!qu.isEmpty()){
            int now = qu.poll();
            //여기에서 visited true하니 시간초과가 나는 문제가 발생함
            for(int node : graph[now]){
                //방문하지 않은 노드 확인하자마자 바로 방문 처리 시키면 성능이 좀 올라갈거라고 예상
                if(!visited[node]) {
                    visited[node] = true;
                    qu.offer(node);
                }
            }
        }
    }
}