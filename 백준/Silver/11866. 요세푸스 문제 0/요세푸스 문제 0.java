import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //원을 이루는 사람들 넣어주기
        List<Integer> circle = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++)
            circle.add(i);

        //결과값 담을 result 리스트
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;//사람 위치 변수
        //n만큼 돌면서 위치 찾기
        for(int i = 0; i < n; i++){
            //indext 찾기
            count = (count + k - 1) % (circle.size());
            //결과값 circle 리스트에서 가져와서 담기
            result.add(circle.remove(count));
        }
        //결과값 출력
        bw.write("<");
        for (int i = 0; i < result.size(); i++) {
            if (i == result.size() - 1)
                bw.write(result.get(i) + ">");
            else
                bw.write(result.get(i) + ", ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}