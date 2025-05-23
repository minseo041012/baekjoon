import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        long n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];
        long result = 0;

        //가지고 있는 랜선 길이 배열에 저장
        for(int i = 0; i < k; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        //n이 1일 경우, 배열에 들어간 숫자가 전부 같으면서 k와 n도 같을 경우
        if(n == 1|| (arr[0] == arr[arr.length - 1] && k > 1 & k == n))
            bw.write(String.valueOf(arr[0]));
        else {
            result = binary_search(n, arr);
            bw.write(String.valueOf(result));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static long binary_search(long n, int arr[]){
        //overflow 방지
        long lo = 0;
        long hi = arr[arr.length - 1];
        long mid = 0;

        while(lo + 1 < hi){
            mid = (lo + hi) / 2;
            int sum = 0;
            //mid로 구해지는 랜선의 개수
            for (int i = 0; i < arr.length; i++){
                sum += arr[i] / mid;
            }
            if (sum < n)
                hi = mid;
            else if(sum >= n)
                lo = mid;
        }
        return lo;
    }
}