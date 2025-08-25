import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int count = 0;//k까지 세는 변수
        Set<String> grade = new LinkedHashSet<>();//클릭을 한 학생 학번

        //규칙 1에 따라 중복된 학번은 put 하지 않는다.
        for(int i = 0; i < l; i++) {
            String temp = br.readLine();
            int size = grade.size();
            grade.add(temp);
            //클릭을 2번 이상 한 학생인 경우
            if(size == grade.size()) {
                grade.remove(temp);
                grade.add(temp);
            }
        }

        Iterator<String> iter = grade.iterator();
        while(iter.hasNext() && count != k){
            sb.append(iter.next()).append("\n");
            count++;
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}