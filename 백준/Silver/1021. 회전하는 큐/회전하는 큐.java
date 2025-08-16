import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> de = new LinkedList<>();
        int count = 0;

        //1~n까지 덱에 담아둔다
        for(int i = 1; i <= n; i++)
            de.addLast(i);

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            int index;

            //덱의 원소가 짝수일 경우 중간 -1 한다
            //인덱스는 0부터 시작하기 때문
            if(de.size() % 2 == 0)
                index = de.size() / 2 - 1;
            else
                index = de.size() / 2;


            //왼쪽 원소 오른쪽으로 이동(2번 연산)
            if(index >= de.indexOf(num)){
                while(num != de.peekFirst()){
                    de.addLast(de.pollFirst());
                    count++;
                }
            }
            //오른쪽 원소 왼쪽으로 이동(3번 연산)
            else{
                while(num != de.peekFirst()){
                    de.addFirst(de.pollLast());
                    count++;
                }
            }
            de.pollFirst();
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}