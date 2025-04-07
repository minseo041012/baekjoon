import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        //n만큼 반복문 돌기
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            //push면 num 스택에 넣기
            if (temp.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                stack.push(num);
            }
            //pop면 stack size 검사 후, 요소 반환 or -1 출력
            else if(temp.equals("pop")){
                if(stack.size() == 0)
                    bw.write(String.valueOf(-1) + "\n");
                else {
                    int tp = stack.pop();
                    bw.write(String.valueOf(tp) + "\n");
                }
            }
            //stack size 출력
            else if(temp.equals("size")){
                bw.write(String.valueOf(stack.size()) + "\n");
            }
            //stack empty이면 1출력 or 0출력
            else if(temp.equals("empty")){
                if(stack.isEmpty())
                    bw.write(String.valueOf(1) + "\n");
                else
                    bw.write(String.valueOf(0) + "\n");
            }
            //젤 위에 있는 요소 출력 삭제는 아님
            else if(temp.equals("top")){
                if(stack.isEmpty())
                    bw.write(String.valueOf(-1) + "\n");
                else
                    bw.write(String.valueOf(stack.peek()) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}