import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int customer = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;//거절 당한 사람의 수

        for(int i = 0; i < customer; i++){
            int size = set.size();
            set.add(Integer.parseInt(st.nextToken()));

            //size가 같으면 자리가 없다는 뜻
            if(size == set.size())
                count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        br.close();
        bw.close();
    }
}