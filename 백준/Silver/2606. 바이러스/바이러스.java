import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int computer = Integer.parseInt(br.readLine());//컴퓨터의 개수
        int pare = Integer.parseInt(br.readLine());//연결된 쌍의 개수
        Graph graph = new Graph(computer);

        for(int i = 0; i < pare; i++){
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            graph.addEdge(temp1, temp2);
        }

        int virus = graph.DFS(1);
        bw.write(String.valueOf(virus - 1));

        bw.flush();
        bw.close();
        br.close();
    }

    static class Graph {
        int vertex;
        LinkedList<Integer> list[];

        public Graph(int vertex) {
            this.vertex = vertex;

            list = new LinkedList[vertex + 1];
            for (int i = 1; i <= vertex; i++)
                list[i] = new LinkedList<>();
        }

        public void addEdge(int source, int destination) {
            list[source].addFirst(destination);
            list[destination].addFirst(source);
        }

        public int DFS(int start) {
            boolean[] visited = new boolean[vertex + 1];
            Stack<Integer> st = new Stack<Integer>();
            int count = 0;
            st.push(start);
            while (!st.isEmpty()) {
                int v = st.pop();
                if (!visited[v]) {
                    count++;
                    visited[v] = true;
                    for (int i = 0; i < list[v].size(); i++) {
                        int dest = list[v].get(i);
                        if (!visited[dest])
                            st.push(dest);
                    }
                }
            }
            return count;
        }
    }
}