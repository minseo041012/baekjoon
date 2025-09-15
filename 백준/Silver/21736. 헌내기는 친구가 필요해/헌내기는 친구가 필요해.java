import java.io.*;
import java.util.*;

public class Main{
    static int loc_row, loc_col;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        String[][] campus = new String[row][col];

        for(int i = 0; i < row; i++){
            String[] temp = br.readLine().split("");
            for(int j = 0; j < col; j++) {
                if(temp[j].equals("I")) {
                    loc_row = i;
                    loc_col = j;
                }
                campus[i][j] = temp[j];
            }
        }

        int count = DFS(campus, row, col);

        if(count == 0)
            bw.write(String.valueOf("TT"));
        else
            bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }

    static int DFS(String[][] campus, int row, int col){
        boolean[][] visited = new boolean[row + 1][col + 1];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        //함수 안에 함수를 선언하는 것은
        class fun{
            int count = 0;
            int dfs(int r, int c){
                //범위를 벗어난 경우
                if(r < 0 || r >= row || c < 0 || c >= col)
                    return 0;
                //이미 방문했거나 갈 수 없는 곳일 경우
                if(campus[r][c].equals("X") || visited[r][c])
                    return 0;
                visited[r][c] = true;
                //사람을 찾았을 경우
                if(campus[r][c].equals("P"))
                    count++;
                //상하좌우 방향 고려해서 다음 위치 선별
                for(int i = 0; i < 4; i++){
                    int next_row = r + dx[i];
                    int next_col = c + dy[i];
                    dfs(next_row, next_col);
                }
                return count;
            }
        }
        return new fun().dfs(loc_row, loc_col);
    }
}