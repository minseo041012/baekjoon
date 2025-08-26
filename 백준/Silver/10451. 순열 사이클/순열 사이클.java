import java.io.*;
import java.util.*;

public class Main{
    static int[] graph;
    static boolean[] visited;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testcase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testcase; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph = new int[n + 1];
            visited = new boolean[n + 1];
            int count = 0;//순열 사이클 개수

            for(int j = 1; j <= n; j++)
                graph[j] = Integer.parseInt(st.nextToken());

            for(int j = 1; j <= n; j++){
                if(!visited[j]){
                    DFS(j);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
    //탐색 노드를 방문 처리하고 이와 연결된 노드를 방문한다.
    //이미 방문이 되었다면 돌아가서 카운트 증가시킨다.
    static void DFS(int index){
        visited[index] = true;
        if(!visited[graph[index]])
            DFS(graph[index]);
    }
}