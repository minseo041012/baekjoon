import java.io.*;
import java.util.*;

public class Main{
    static int user, line;
    static LinkedList<Integer> relation[];
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        user = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());

        relation = new LinkedList[user + 1];
        for(int i = 1; i <= user; i++)
            relation[i] = new LinkedList<>();

        for(int i = 0; i < line; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //친구니까 양방향
            relation[a].addLast(b);
            relation[b].addLast(a);
        }
        int min = Integer.MAX_VALUE;//케빈 베이컨 수
        int person = 0;//유저 번호

        for(int i = 1; i <= user; i++){
            int temp = bfs(i);

            //케빈 베이컨 수가 적은 경우
            if(temp < min) {
                min = temp;
                person = i;
            }
        }

        bw.write(String.valueOf(person));
        bw.flush();
        bw.close();
        br.close();
    }

    //너비 우선 탐색
    static int bfs(int a){
        boolean[] visited = new boolean[user + 1];
        Queue<Integer> st = new LinkedList<Integer>();
        int result = 0;
        int count = 1;
        st.add(a);
        visited[a] = true;
        int len = st.size();

        while(!st.isEmpty()){
            int start = st.poll();

            for(int i = 0; i < relation[start].size(); i++) {
                int dest = relation[start].get(i);
                if(!visited[dest] && dest!= a) {
                    visited[dest] = true;
                    result += count;
                    st.offer(dest);
                }
            }
            len--;
            if(len == 0) {
                len = st.size();
                count++;
            }
        }

        return result;
    }
}