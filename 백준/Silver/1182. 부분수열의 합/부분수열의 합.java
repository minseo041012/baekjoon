import java.io.*;
import java.util.*;

public class Main{
    static int count = 0;
    static int n, s;
    static int[] arr;
    static boolean[] visited;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        backtracking(0, 0);

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static void backtracking(int sum, int index){
        if(index > 0 && sum == s){
            count++;
        }

        for(int i = index; i < n; i++){
            if(!visited[i]){
                visited[i]= true;
                backtracking(sum + arr[i], i + 1);//index를 i + 1로 넘겨주면서 중복 허용하지 않음
                visited[i] = false;
            }
        }
    }
}