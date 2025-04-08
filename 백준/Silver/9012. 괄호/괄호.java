import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] s = new String[50];

        int input = Integer.parseInt(br.readLine());
        for(int i = 0; i < input; i++){
            int front = 0;//'('개수 확인 변수
            int back = 0;//')' 개수 확인 변수
            int temp = 1;

            s = br.readLine().split("");
            for(int j = 0; j < s.length; j++){
                //배열에 "("가 있으면 front 증가
                if(s[j].equals("(")){
                    front++;
                }
                //배열에 ")"가 있으면 back 증가
                else if(s[j].equals(")")) {
                    if(front > back)
                        back++;
                    else{
                        back = -1;
                        break;
                    }
                }
            }
            //개수 같으면서 쌍이 잘 맞으면 yes 출력
            if(front == back && temp == 1)
                sb.append("YES" + "\n");
            else
                sb.append("NO" + "\n");
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }
}