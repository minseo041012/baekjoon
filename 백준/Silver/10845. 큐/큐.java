import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> qu = new LinkedList<>();

        int input = Integer.parseInt(br.readLine());

        for(int i = 0; i < input; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("push")){
                int temp = Integer.parseInt(st.nextToken());
                qu.offer(temp);
            }
            //empty면 -1, 아니면 맨 앞 정수 출력 후 삭제
            else if(s.equals("pop")){
                if(qu.isEmpty())
                    sb.append("-1").append("\n");
                else
                    sb.append(qu.poll()).append("\n");
            }
            //size 0이면 -1, 아니면 개수 출력
            else if(s.equals("size")){
                if(qu.isEmpty())
                    sb.append("0").append("\n");
                else
                    sb.append(qu.size()).append("\n");
            }
            //empty면 1, 아니면 0 출력
            else if(s.equals("empty")){
                if(qu.isEmpty())
                    sb.append("1").append("\n");
                else
                    sb.append("0").append("\n");
            }
            //empty면 -1, 아니면 맨 앞 숫자 출력
            else if(s.equals("front")){
                if(!qu.isEmpty())
                    sb.append(qu.peekFirst()).append("\n");
                else
                    sb.append("-1").append("\n");
            }
            //empty면 -1, 아니면 맨 뒤 숫자 출력
            else if(s.equals("back")){
                if(!qu.isEmpty())
                    sb.append(qu.peekLast()).append("\n");
                else
                    sb.append("-1").append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}