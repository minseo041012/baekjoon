import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int repeat = Integer.parseInt(br.readLine());

        for(int a = 0; a < repeat; a++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int a1 = 0;//첫번 째 항
            int a2 = 1;//두번 째 항
            int temp;//임시 저장 변수
            long cycle = 1;//주기

            for(long i = 0; i < (long)m * m; i++){
                temp = a2;
                a2 = (a1 + a2) % m;
                a1 = temp;

                //첫번째 항과 두번 째 항이랑 숫자가 같다면 주기 반복된다는 것으로 간주
                if(a1 == 0 && a2 == 1)
                    break;
                //아니면 주기 1씩 추가
                else
                    cycle++;
            }
            sb.append(num).append(" ").append(cycle).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}