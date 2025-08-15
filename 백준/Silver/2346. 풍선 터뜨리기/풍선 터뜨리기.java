import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> order = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        //dq에는 종이에 적힌 수를 넣어준다
        //map에는 종이에 적힌 수의 순서를 넣어준다
        for(int i = 1; i <= n; i++) {
            dq.add(Integer.parseInt(st.nextToken()));
            order.add(i);
        }
        //시작은 무조건 1번부터 시작하기
        int num = dq.removeFirst();
        order.pollFirst();
        sb.append(1).append(" ");

        while(!dq.isEmpty()){
            //적힌 수가 양수일 경우
            if(num > 0){
                //앞에 적힌 수를 맨 뒤로 add 해주기
                for(int i =0; i < num - 1; i++) {
                    dq.addLast(dq.pollFirst());
                    order.addLast(order.pollFirst());
                }
                sb.append(order.pollFirst()).append(" ");//map에서 순서 가져와서 sb에 넣어주기
                num = dq.removeFirst();//종이 적힌 수 가져오면서 삭제하기
            }
            //적힌 수가 음수일 경우
            else{
                //맨 뒤에서부터 앞으로 add 해주기
                for(int i = num; i < -1; i++){
                    dq.addFirst(dq.pollLast());
                    order.addFirst(order.pollLast());
                }
                sb.append(order.pollLast()).append(" ");
                num = dq.removeLast();
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}