import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int ver = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list[] = new ArrayList[ver + 1];

        //linkedlist 초기화
        for(int i = 0; i <= ver; i++)
            list[i] = new ArrayList<>();

        //각 정점에 연결된 다른 정점 입력
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        //인접 정점 오름차순으로 방문해야 하기 때문에 내림차순으로 정렬
        for(int i = 1; i <= ver; i++){
            Collections.sort(list[i], Collections.reverseOrder());
        }

        int[] pro = dfs(ver, m, start, list);

        //각 정점 방문 순서 출력
        for(int i = 1; i <= ver; i++) {
            sb.append(pro[i]).append("\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] dfs(int ver, int m, int start, ArrayList list[]){
        boolean visited[] = new boolean[ver + 1];
        Stack<Integer> st = new Stack<>();
        int[] pro = new int[ver + 1];//방문 순서 저장하는 배열
        int count = 1;//방문 순서 기록할 변수
        st.add(start);

        while(!st.empty()){
            int temp = st.pop();
            //방문하지 않았을 경우
            if(!visited[temp]){
                pro[temp] = count++;//방문 순서 저장
                visited[temp] = true;//방문 했다고 변경
                for (int i = 0; i < list[temp].size(); i++) {
                    int dest = (int) list[temp].get(i);
                    if (!visited[dest])
                        st.push(dest);
                }
            }
        }
        return pro;
    }
}