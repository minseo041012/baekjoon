import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] arr;

        while(true){
            int big = 0;
            int small = 0;
            String s = br.readLine();
            arr = s.split("");
            Stack<String> st = new Stack<>();
            //괄호가 하나도 없는 경우는 yes로 출력
            if (arr[0].equals("."))
                break;
            for(int i = 0; i < arr.length; i++){
                //"("일 경우 small 증가
                if(arr[i].equals("(")){
                    st.add(arr[i]);
                    small++;
                }
                //")"일 경우 small 감소 & 사전에 "("이 존재했어야함
                if(arr[i].equals(")") && small > 0){
                    String temp = st.pop();
                    if(!temp.equals("(")) {
                        sb.append("no" + "\n");
                        break;
                    }
                    small--;
                }
                else if (arr[i].equals(")") && small == 0){
                    sb.append("no" + "\n");
                    break;
                }
                //"["일 경우, big 증가
                if(arr[i].equals("[")) {
                    st.add(arr[i]);
                    big++;
                }
                //"]"일 경우 big 감소 & 사전에 "]"이 존재했어야함
                if(arr[i].equals("]") && big > 0){
                    String temp = st.pop();
                    if(!temp.equals("[")) {
                        sb.append("no" + "\n");
                        break;
                    }
                    big--;
                }
                else if (arr[i].equals("]") && big == 0){
                    sb.append("no" + "\n");
                    break;
                }

                //문장의 끝 확인하기
                if(arr[i].equals(".")){
                    if(small == 0 && big == 0)
                        sb.append("yes" + "\n");
                    else
                        sb.append("no" + "\n");
                }
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}