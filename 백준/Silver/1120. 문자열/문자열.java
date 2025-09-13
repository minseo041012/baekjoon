import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] A = st.nextToken().split("");
        String[] B = st.nextToken().split("");
        int gap = A.length;

        for(int i = 0; i <= B.length - A.length; i++){
            int temp = 0;
            for(int j = i; j < i + A.length; j++){
                if(!A[j - i].equals(B[j]))
                    temp++;
            }
            //차이가 최소일 경우, gap 값 갱신
            if(temp < gap)
                gap = temp;
        }

        bw.write(String.valueOf(gap));
        bw.flush();
        bw.close();
        br.close();
    }
}