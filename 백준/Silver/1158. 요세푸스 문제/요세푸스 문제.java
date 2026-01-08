import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        //요세푸스 문제
        //덱 사용해서 앞 원소를 뒤에 넣는 것 k - 1 반복
        //덱에 아무것도 없을 때까지 무한 반복
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 1; i <= n; i++)
            dq.add(i);

        int count = 0;
        sb.append("<");

        while(!dq.isEmpty()){
            if(count == k - 1){
                sb.append(dq.pollFirst());
                count = 0;
                //마지막 원소 전까지 , 추가
                if(!dq.isEmpty())
                    sb.append(", ");
            }
            //앞 원소를 뒤에 넣기
            else {
                dq.addLast(dq.pollFirst());
                count++;
            }
        }

        sb.append(">");
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}