import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int input = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        //set 사용해서 중복 제거
        for(int i = 0; i < input; i++)
            set.add(br.readLine());
        
        List<String> list = new ArrayList<>(set);
        Collections.sort(list, new swap_length());

        //출력
        for(int i = 0; i < set.size(); i++)
            sb.append(list.get(i)).append("\n");

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
    static class swap_length implements Comparator<String>{
        public int compare(String a, String b){
            if(a.length() != b.length())
                return a.length() - b.length();
            return a.compareTo(b);
        }
    }
}