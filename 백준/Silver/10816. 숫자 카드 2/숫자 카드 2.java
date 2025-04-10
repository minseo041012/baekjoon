import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //n입력 받아 n만큼의 배열 생성 후 값 넣어주기
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            //temp라는 키가 이미 존재한다면 value 1씩 올리기
            if(map.containsKey(temp))
                map.put(temp, map.get(temp) + 1);
            //아니면 value 1으로 넣어주기
            else
                map.put(temp, 1);
        }
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++){
            int temp = Integer.parseInt(st.nextToken());
            //map에 temp 키가 존재한다면 value값 append
            if(map.containsKey(temp))
                sb.append(map.get(temp)).append(" ");
            //존재하지 않는다면 0 append
            else
                sb.append("0").append(" ");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}