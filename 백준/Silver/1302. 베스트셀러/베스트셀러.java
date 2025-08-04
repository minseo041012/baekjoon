import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> book = new HashMap<>();
        HashSet<String> store = new HashSet<>();
        int max = 1;
        int count = 0;

        for(int i = 0; i < n; i++){
            String name = br.readLine();
            if(n == 1) {
                sb.append(name);
                break;
            }
            //이미 존재하면 횟수가 1 증가
            if(book.containsKey(name)){
                count = book.get(name);
                book.replace(name, ++count);
             }
            //없으면 1 넣기
            else {
                book.put(name, 1);
                count = 1;
            }
            //최다 호명된 책이면 이전 기록 없애고 set에 넣어주기
            if(count > max){
                max = count;
                store.clear();
                store.add(name);
            }
            else if(count == max)
                store.add(name);
        }
        List<String> temp = new ArrayList<>(store);
        Collections.sort(temp);

        if(sb.length() == 0)
            sb.append(temp.get(0));

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}