import java.io.*;
import java.util.*;

public class Main{
    static int n, m, sum, board[][], selected[];
    static boolean[] visited;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        selected = new int[3];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            board[a][b] = 1;
            board[b][a] = 1;
        }

        sum = 0;
        combination(0, 1);
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
    static void combination(int count, int start){
        //3개의 아이스크림을 선택했을 때 모두 0이라면 섞어먹어도 되는 조합
        if(count == 3){
            if(board[selected[0]][selected[1]]==1 ||
                board[selected[1]][selected[2]] == 1 ||
                    board[selected[2]][selected[0]] == 1)
                return;

            sum++;
            return;
        }

        for(int i = start; i <= n; i++){
            if(!visited[i]){
                visited[i] = true;
                selected[count] = i;
                combination(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}