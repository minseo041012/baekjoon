import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count = 0;//그룹 단어 개수 체크

        for(int i = 0; i < n; i++){
            HashSet<String> set = new HashSet<>();//이미 나온 문자인지 아닌지 체크
            String[] arr = br.readLine().split("");
            for(int j = 0; j < arr.length; j++){
                int size = set.size();
                set.add(arr[j]);
                //사이즈 비교하면서 연속해서 나오는지 아닌지 확인
                if(set.size() == size && j != 0 && !arr[j - 1].equals(arr[j])) {
                    set.clear();//그룹 단어가 아니라면 비워주기
                    break;
                }
            }
            //empty가 아니라면 count 증가
            if(!set.isEmpty())
                count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}