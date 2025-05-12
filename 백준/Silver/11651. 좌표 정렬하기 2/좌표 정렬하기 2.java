import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        ArrayList<xy> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        //arraylist에 x, y좌표 넣기
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new xy(x, y));
        }
        //객체 리스트 정렬 -> y좌표를 기준으로 정렬, y좌표가 같을 경우 x좌표로 정렬
        Collections.sort(list, Comparator.comparing(xy::getY).thenComparing(xy::getX));
        //정렬된 값 출력
        for(int i = 0; i < n; i++){
            xy temp = list.get(i);
            bw.write(String.valueOf(temp.getX()) +" "+ String.valueOf(temp.getY()) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static class xy{
        int x;
        int y;

        public xy(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}