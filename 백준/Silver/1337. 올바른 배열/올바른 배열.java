import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        long[] arr = new long[size + 1];
        int count = 1;
        int temp = 1;
        int start = 1;


        for(int i = 0; i < size; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);//배열 오름차순으로 정렬
        int i = 1;
       while(i < size){
            //시작 인덱스 고정하고 차이가 5이하인지 확인
            if(arr[i + 1] < arr[start] + 5) {
                temp++;
                i++;
            }
            //오차가 5 초과하면 시작 인덱스를 바로 다음 인덱스로 변경
            else {
                start++;
                i =  start;
                temp = 1;
            }
            //연속된 숫자가 많은 걸로 count변경
            if(temp > count)
                count = temp;
        }

        bw.write(String.valueOf(5 - count));
        bw.flush();
        bw.close();
        br.close();
    }
}