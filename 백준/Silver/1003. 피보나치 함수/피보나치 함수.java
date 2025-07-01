import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[40];//fibo 수열 dp로 저장
        arr[0] = 0;
        arr[1] = 1;
        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            int temp[] = fibo(arr, m);
            bw.write(String.valueOf(temp[0]) + " " + String.valueOf(temp[1]) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    static int[] fibo(int arr[], int m){
        int[] num = new int[2];//0 1 호출 횟수 반환
        HashMap<Integer, List<Integer>> list = new HashMap<Integer, List<Integer>>();
        list.put(0, Arrays.asList(1, 0));
        list.put(1, Arrays.asList(0, 1));
        //예외처리
        if(m == 0){
            num[0]++;
            return num;
        }
        else if (m == 1){
            num[1]++;
            return num;
        }
        //fibo 구하는 반복문
        for(int i = 2; i <= m; i++){
//            int temp1 = arr[i - 1];
//            int temp2 = arr[i - 2];
//            if(temp1 == arr[0] || temp2 == arr[0])
//                num[0]++;
//            if(temp1 == arr[1] || temp2 == arr[1])
//                num[1]++;
//            arr[i] = temp1 + temp2;
            int a = list.get(i - 1).get(0), b= list.get(i - 1).get(1);
            int c = list.get(i - 2).get(0), d = list.get(i - 2).get(1);
            list.put(i, Arrays.asList(a + c, b + d));
        }
        num[0] = list.get(m).get(0);
        num[1] = list.get(m).get(1);
        return num;
    }
}