import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A_size = Integer.parseInt(st.nextToken());
        int B_size = Integer.parseInt(st.nextToken());
        int[] arr = new int[A_size + B_size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < A_size; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < B_size; i++)
            arr[i + A_size] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++)
            sb.append(arr[i]).append(" ");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}