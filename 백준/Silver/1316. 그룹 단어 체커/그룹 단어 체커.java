import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;//그룹 단어 개수 체크

        for(int i = 0; i < n; i++){
            boolean[] alpha = new boolean[26];//알파벳 나온지 안나온지 확인 -> 나온거면 true로 변경
            String arr = br.readLine();
            int pre = 0;//이전 문자 비교
            boolean flag = true;//중간 break되었는지 판별

            for(int j = 0; j < arr.length(); j++){
                int now = arr.charAt(j);

                //이전 문자와 현재 문자가 같지않고
                if(pre != now){
                    //이 문자가 처음 나왔을 경우
                    if(alpha[now - 'a'] == false){
                        alpha[now-'a']=true;
                        pre = now;
                    }
                    //이전에 한 번 등장했을 경우
                    else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag)
                count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }


}