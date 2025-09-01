import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alpha = new int[26];
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            //대문자일 경우
            if('A' <= s.charAt(i) && s.charAt(i) <= 'Z')
                alpha[s.charAt(i) - 'A']++;//-'A'는 인덱스 벗어나지 않도록 하기 위해
            else
                alpha[s.charAt(i) - 'a']++;
        }

        int max = -1;
        char answer = '?';

        for(int i = 0; i < 26; i++){
            if(alpha[i] > max) {
                max = alpha[i];
                answer = (char)(i + 65);//대문자로 출력해야 하기 때문에, 65 더함
            }
            else if(max == alpha[i])
                answer = '?';
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}