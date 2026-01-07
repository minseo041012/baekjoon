import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while(true){
            int n = Integer.parseInt(br.readLine());

            //종료조건
            if(n == 0)
                break;

            int[] arr = new int[n];//키 저장할 배열
            HashMap<Integer, List<String>> map = new HashMap<>();//키와 이름 저장할 해시맵

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                arr[i] = (int)(Double.parseDouble(st.nextToken()) * 100);//정수만 넣을 수 있기 떼문에 100 곱하고 int로 형변환

                map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(name);
            }
            Arrays.sort(arr);//최대값 구하기 위한 정렬
            int max = arr[n - 1];

            //같은 키 여러 명일 경우 모두 고려해서 출력
            List<String> valueList = map.get(max);
            for(String name : valueList)
                sb.append(name).append(" ");
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}