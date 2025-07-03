import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        int size = 0;
        HashSet<String> set= new HashSet<>();
        List<String> result = new ArrayList<>();

        //듣도 못한 사람 hashset에 추가
        for(int i = 0; i < n; i++)
            set.add(br.readLine());
        //보도 못한 사람
        for(int i = 0; i < m; i++) {
            String temp = br.readLine();
            size = set.size();
            set.add(temp);
            //중복인 경우 -> 듣도 보도 못한 사람
            if(size == set.size()){
                count++;
                result.add(temp);
            }
        }
        //듣도 보도 못한 놈들 이름순으로 정렬
        Collections.sort(result);
        bw.write(String.valueOf(count) + "\n");
        //list 순회
        for(int i = 0; i < result.size(); i++)
            bw.write(result.get(i) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}