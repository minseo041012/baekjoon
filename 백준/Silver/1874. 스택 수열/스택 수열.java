import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int temp = 1;
        int pop = -1;
        int count = 0;
        int num = 0;

        loopOut:
        while(true){
            if(count != n){
            num = Integer.parseInt(br.readLine());
            count++;
            }
            //stack이 비었으면 탈출
            if(temp == n + 1 && st.isEmpty() && num == pop)
                break;


            //stack에 값 넣기
            for(; temp <= num; temp++){
                st.push(temp);
                sb.append("+" + " \n");
            }
            while(true) {
                //num이 stack에 존재하지 않는 경우
                if(st.isEmpty()) {
                    sb.setLength(0);
                    sb.append("NO");
                    break loopOut;
                }
                pop = st.pop();
                //찾은 경우
                if(pop == num) {
                    sb.append("-" + "\n");
                    break;
                }
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}