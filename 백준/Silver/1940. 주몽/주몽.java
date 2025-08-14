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

        int start = 0;
        int end = n - 1;

        //시작 인덱스와 끝 인덱스를 움직여서 개수 구함
        while(start < end){
            //m보다 작은 경우, 시작인덱스를 하나씩 증가시킴
            if(arr[start] + arr[end] < m)
                start++;
            //m보다 클 경우, 끝 인덱스를 하나씩 감소시킴
            else if(arr[start] + arr[end] > m)
                end--;
            //합이 m인 경우, count증가 시키고 인덱스도 움직임
            else{
                count++;
                start++;
                end--;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}