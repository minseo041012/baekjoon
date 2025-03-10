import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<Integer>> num = new HashMap<>();

        //c에 입력 받은 좌표 삽입
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(!num.containsKey(x))
                num.put(x, new ArrayList<>());
            num.get(x).add(y);
        }
        //정렬된 treemap 구하기
        Map<Integer, List<Integer>> sorted = new TreeMap<>(num);

        for(Integer x : sorted.keySet()){
            sorted.get(x).sort(Comparator.naturalOrder());
            for(Integer y : sorted.get(x)){
                bw.write(String.valueOf(x) + " " + String.valueOf(y) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}