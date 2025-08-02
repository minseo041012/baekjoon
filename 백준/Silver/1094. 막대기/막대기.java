import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;
        int length = 0;
        Deque<Integer> qu = new LinkedList<>();
        qu.add(64);


        while(true){
            //n이 64인 경우, 그냥 반복문 탈출
            if(n == 64)
                break;
            int temp = qu.poll()/2;
            qu.addFirst(temp);
            length += temp;
            //막대의 길이가 n보다 작을 경우, 위에서 자른 막대 하나 더 add 시킨다
            if(length < n)
                qu.addFirst(temp);
            //길이가 n에 도달하면, 반복문 탈출
            else if(length == n)
                break;
            //길이가 n보다 클 경우, length에서 temp만큼 뺴준다
            else
                length -= temp;
        }
        //요소들을 전부 합해서 막대의 개수 찾기
        for(int i = 0; i < qu.size(); i++)
            count++;
        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }
}