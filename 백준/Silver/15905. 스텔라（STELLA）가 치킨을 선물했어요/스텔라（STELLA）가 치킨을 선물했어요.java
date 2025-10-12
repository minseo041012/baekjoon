import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        Integer[] person = new Integer[input];
        int count = 0;

        for(int i = 0; i < input; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            person[i] = Integer.parseInt(st.nextToken());
            st.nextToken();
        }
        //내림차순으로 정렬
        Arrays.sort(person, Collections.reverseOrder());
        int temp = person[4];

        //입력이 5가 아닌 경우만 반복문 돌기
        if(input != 5){
            for(int i = 0; i < input && temp <= person[i]; i++) {
                //5등이랑 푼 문제가 같은 사람 -> 6, 7 ... input까지 찾아주기
                if(temp == person[i] && i > 4)
                    count++;
            }
            bw.write(String.valueOf(count));
        }
        else
            bw.write(String.valueOf(0));


        bw.flush();
        br.close();
        bw.close();
    }
}