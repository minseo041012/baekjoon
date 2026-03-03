import java.io.*;
import java.util.*;

/**
 * 좌표압축은 입력받은 좌표들을 가지고 각각의 좌표보다 작은 좌표의 개수를 출력하는 알고리즘
 * step1: 좌표들을 배열로 입력을 받기
 * step2: hashmap을 이용해서 중복 요소 제거 -> treeset을 쓸 경우 시간복잡도 O(nlogn)
 * step3: value 출력*/
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        Integer[] sort = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        sort = arr.clone();
        Arrays.sort(sort);
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0; 
        
        for(int i = 0; i < n; i++)
            if(!map.containsKey(sort[i]))
                map.put(sort[i], index++);

        for(int i = 0; i < n; i++){
           sb.append(map.get(arr[i]) + " ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}