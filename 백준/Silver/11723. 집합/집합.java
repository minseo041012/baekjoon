import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int m = Integer.parseInt(br.readLine());
        HashSet<Integer> empty_set = new HashSet<>();
        //all 명령어 위한 hashset
        HashSet<Integer> all = new HashSet<>();
        for(int i = 1; i <= 20; i++)
            all.add(i);
        int num = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    empty_set.add(num);
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    empty_set.remove(num);
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    if(empty_set.contains(num))
                        bw.write(String.valueOf(1) + "\n");
                    else
                        bw.write(String.valueOf(0) + "\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    if(empty_set.contains(num))
                        empty_set.remove(num);
                    else
                        empty_set.add(num);
                    break;
                case "all":
                    HashSet<Integer> temp = (HashSet<Integer>)all.clone(); //all 데이터 훼손 방지
                    empty_set = temp;
                    break;
                case "empty":
                    empty_set.clear();
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}