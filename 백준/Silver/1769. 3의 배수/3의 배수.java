import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split("");
        int num = 0;
        int count;

        //입력된 값의 총 합 구하기
        for(int i = 0; i < arr.length; i++){
            num += Integer.parseInt(arr[i]);
        }
        if(arr.length != 1)
            count = 1;//변환 과정 횟수
        else
            count = 0;

        while(true){
            //num이 일의 자리 수일 경우
            if(0 < num && num < 10){
                break;
            }
            int temp = num;
            num = 0;
            while(temp!=0){
                num += temp % 10;
                temp /= 10;
            }
            count++;
        }

        //3의 배수이면 횟수와 yes 출력
        if(num % 3 == 0)
            sb.append(count).append("\n").append("YES");
        //3의 배수가 아니면 no 출력
        else
            sb.append(count).append("\n").append("NO");
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
        br.close();
    }
}