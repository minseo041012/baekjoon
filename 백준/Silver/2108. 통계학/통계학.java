import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        double mean = 0;
        int count = 0;
        int mid = 0;
        int mode = 0;
        int change = 0;
        int check;
        boolean flag = true;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(br.readLine());
            //map에 key값이 이미 존재하면 count값만 업데이트
            if(map.containsKey(temp)){
                count = map.getOrDefault(temp, count);
                map.replace(temp, count + 1);
            }
            else {
                map.put(temp, 1);
            }
            mean += temp;
        }
        //key값 기준으로 정렬
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet);

        check = n/2;
        int range = keySet.get(map.size() - 1) - keySet.get(0);
        Integer maxValue = Collections.max(map.values());
        for(Integer key : keySet){
            if(map.get(key).equals(maxValue) && change < 2){
                mode = key;
                change++;
            }
            check -= map.get(key);
            if(check < 0 && flag){
                mid = key;
                flag = false;
            }
        }

        bw.write(String.valueOf(Math.round(mean/n)) + "\n");
        bw.write(String.valueOf(mid) + "\n");
        bw.write(String.valueOf(mode) + "\n");
        bw.write(String.valueOf(range));
        bw.flush();
        bw.close();
        br.close();
    }
}