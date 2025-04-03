import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> number = new LinkedList<>();
        //n까지의 숫자 queue에 삽입
        for(int i = 1; i <= n; i++)
            number.offerLast(i);
        //1만 입력되었을 경우 예외처리해주기
        if (number.size() == 1) {
            bw.write(String.valueOf(1));
            bw.flush();
            return;
        }
        //number가 비어있지않을 때까지 작동
        while(!number.isEmpty()){
            number.removeFirst();
            //size가 1이라면 break
            if(number.size() == 1){
                bw.write(String.valueOf(number.element()));
                break;
            }
            //맨 앞 숫자를 맨뒤에 넣어주면서 삭제시키기
            number.offerLast(number.pollFirst());
        }
        /*메모리 공간 확인코드
        Runtime.getRuntime().gc();
        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println(usedMemory + " bytes");*/

        bw.flush();
        bw.close();
        br.close();
    }
}