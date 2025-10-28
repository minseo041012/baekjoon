import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int result = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            arr[i] = (Integer.parseInt(st.nextToken()));

        //오름차순으로 정렬하면 줄을 가장 적게 사용할 수 있다
        Arrays.sort(arr);

        for(int i = 0; i < n - 1; i++){
            int substract = Math.abs(arr[i] - arr[i + 1]);
            result += (substract * 2);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}