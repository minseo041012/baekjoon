import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] s = br.readLine().split("");
        String temp = "";

        for(int i = 0; i < s.length; i++){
            //단어가 공백으로 끝나는 경우
            if(s[i].equals(" ")){
                String result = new StringBuilder(temp).reverse().toString();
                sb.append(result).append(" ");
                temp = "";
            }
            else if(s[i].equals("<")){
                //이전에 저장된 문자열을 뒤집어서 sb에 붙여준다
                String result = new StringBuilder(temp).reverse().toString();
                sb.append(result);
                temp = "";
                //>를 만날떄까지 temp에 덧붙여준다
                while(!s[i].equals(">")){
                    temp = temp + s[i];
                    i++;
                }
                temp = temp + s[i];//>를 붙여주는 작업
                sb.append(temp);
                temp = "";
            }
            else
                temp = temp + s[i];
        }
        //마지막으로 temp에 저장된 문자열 뒤집어서 sb에 붙여준다
        String result = new StringBuilder(temp).reverse().toString();
        sb.append(result);

        bw.write(String.valueOf(sb));
        bw.flush();
        br.close();
        bw.close();
    }
}