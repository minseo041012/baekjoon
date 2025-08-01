import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());
        int jimin = Integer.parseInt(st.nextToken());
        int round = 1;
        int num = 0;//num은 다음 라운드 참가자 수
        int count = 1;

        while(n >= 1){
            //부전승 고려해서 몫 1 일때, num++하기
            if(count % 2 == 1)
                num++;
            //한수 다음 라운드 참가 순서
            if(count == hansu)
                hansu = num;
            //지민 다음 라운드 참가 순서
            if(count == jimin)
                jimin = num;
            //한수와 지민의 다음 라운드 순서가 같을 경우
            if(hansu == jimin) {
                bw.write(String.valueOf(round));
                break;
            }
            //다음 라운드로 가기 위한 정리
            if(count == n){
                n = num;
                round++;
                count = 0;
                num = 0;
            }
            count++;
        }
        //만약 대결하지 않는 경우
        if(hansu != jimin)
            bw.write(String.valueOf(-1));

        bw.flush();
        bw.close();
        br.close();
    }
}