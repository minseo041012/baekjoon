import java.io.*;
import java.util.*;


public class Main{
    static StringBuilder sb = new StringBuilder();
    static int vertex, edge, start;
    static ArrayList<Integer>[] list;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        list = new ArrayList[vertex + 1];

        //list 배열 초기화
        for(int i = 1; i <= vertex; i++)
            list[i] = new ArrayList<>();

        //edge 양방향으로 추가
        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int ed1 = Integer.parseInt(st.nextToken());
            int ed2 = Integer.parseInt(st.nextToken());

            list[ed1].add(ed2);
            list[ed2].add(ed1);
        }

        //내림차순으로 정렬
        for(int i = 1; i <= vertex; i++)
            Collections.sort(list[i], Collections.reverseOrder());
        DFS();

        //오름차순으로 정렬
        for(int i = 1; i <= vertex; i++)
            Collections.sort(list[i]);
        BFS();

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static void BFS(){
        boolean[] visited = new boolean[vertex + 1];
        Queue<Integer> qu = new LinkedList<>();

        qu.offer(start);
        visited[start] = true;

        while(!qu.isEmpty()){
            int temp = qu.poll();
            sb.append(temp).append(" ");
            for(int i = 0; i < list[temp].size(); i++){
                int dest = list[temp].get(i);
                if(!visited[dest]){
                    visited[dest] = true;
                    qu.offer(dest);
                }
            }
        }

        sb.append("\n");
    }
    static void DFS(){
        boolean visited[] = new boolean[vertex + 1];
        Stack<Integer> st = new Stack<>();
        st.add(start);

        while(!st.isEmpty()){
            int temp = st.pop();
            if(!visited[temp]) {
                visited[temp] = true;
                sb.append(temp).append(" ");
                for (int i = 0; i < list[temp].size(); i++) {
                    int dest = list[temp].get(i);
                    if (!visited[dest])
                        st.push(dest);
                }
            }
        }
        sb.append("\n");
    }
}