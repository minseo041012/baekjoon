import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        double sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        //입력 받은 점수 배열에 저장
        for(int i = 0; i < n; i++)
            arr[i] = Double.parseDouble(st.nextToken());
        //배열을 stream으로 변환하고 최대값 찾고 double형식으로 가져오는 방법
        double max = Arrays.stream(arr).max().getAsDouble();
        //점수/max * 100 계산
        for (int i = 0; i < n; i++){
            double temp = arr[i];
            arr[i] = temp/max * 100;
            sum += arr[i];
        }
        bw.write(String.valueOf(sum / n));

        bw.flush();
        bw.close();
        br.close();
    }
}