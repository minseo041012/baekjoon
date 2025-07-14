import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(br.readLine());
            int count= 1;
            HashSet<String[]> check = new HashSet<>();
            HashMap<String, Integer> cloth = new HashMap<>();

            //m이 0이면, 0 write후 다음 m 입력받기
            if (m == 0){
                bw.write(String.valueOf(0) + "\n");
                continue;
            }
            for(int j = 0; j < m; j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String temp = st.nextToken();
                //이미 존재하는 경우, 종류의 개수 +1
                if (cloth.containsKey(temp))
                    cloth.put(temp, cloth.get(temp) + 1);
                else
                    cloth.put(temp, 1);
            }

            for(Integer value: cloth.values())
                count *= (value + 1);

            bw.write(String.valueOf(count - 1) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}