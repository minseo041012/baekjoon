import java.io.*;
import java.util.*;


public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int repeat = Integer.parseInt(br.readLine());
        String[] number = new String[repeat];

        for(int i = 0; i < repeat; i++)
            number[i] = br.readLine();
        int count = number[0].length();

        for(int i = number[0].length(); i >= 0; i--){
            HashSet<String> set = new HashSet<>();//중복 값 무시
            //학생 번호를 i~end까지 자르기
            for(int j = 0; j < repeat; j++)
                set.add(number[j].substring(i));
            //겹치는 부분이 없을 경우
            if(set.size() == repeat){
                count = number[0].length() - i;
                break;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}