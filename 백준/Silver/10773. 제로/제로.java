import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

       int k = Integer.parseInt(br.readLine());
       int[] num = new int[k + 1];
       int top = -1;
       for(int i = 0; i < k; i++){
           int temp = Integer.parseInt(br.readLine());
           if(temp == 0){
               if(top == -1)
                   continue;
               else
                   num[top--] = 0;
           }
           else
               num[++top] = temp;
       }
       int result = 0;
       for(int i = 0; i < num.length; i++)
           result += num[i];
       bw.write(String.valueOf(result));

       bw.flush();
       bw.close();
       br.close();
    }
}