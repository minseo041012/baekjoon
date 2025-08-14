import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        //재료의 고유한 번호 배열에 저장
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);//배열을 오름차순으로 정렬

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                //번호를 합쳤을 때, m이 된다면 count 증가
                if(arr[i] + arr[j] == m)
                    count++;
                //합이 m을 넘어간다면 break 해서 시간 줄이기
                if(arr[i] + arr[j] > m)
                    break;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}