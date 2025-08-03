import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int count = 1;


        while(true){
            String[] name = new String[101];
            HashSet<Integer> list = new HashSet<>();
            int n = Integer.parseInt(br.readLine());
            //0입력 받으면 종료
            if(n == 0)
                break;
            //이름을 입력 받기
            for(int i = 1; i <= n; i++)
                name[i] = br.readLine();
            //압수 당한 학생 입력 받기
            for(int i = 0; i < 2*n - 1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                String group = st.nextToken();
                //size가 같으면 먼저 압수당했기에 돌려주는 작업하기
                int size = list.size();
                list.add(num);
                if(size == list.size())
                    list.remove(num);
            }
            //돌려받지 못한 학생 이름 출력하기
            Iterator<Integer> iter = list.iterator();
            while(iter.hasNext()) {
                sb.append(count).append(" ").append(name[iter.next()]).append("\n");
                count++;
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}