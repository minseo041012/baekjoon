import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr;
        int[] m = new int[n];
        int sum = 0;
        int temp = 0;
        arr = br.readLine().split(" ");
        for(int i = 0; i < n; i++)
            m[i] = Integer.parseInt(arr[i]);
        Arrays.sort(m);

        for(int i = 0; i < n; i++){
            temp += m[i];
            sum += temp;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
        br.close();
    }
}