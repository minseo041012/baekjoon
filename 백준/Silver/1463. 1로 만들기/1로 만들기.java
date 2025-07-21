import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] overlap = new int[n + 4];
        int temp;

        overlap[1] = 0;
        overlap[2] = 1;
        overlap[3] = 1;
        overlap[4] = 2;

        for(int index = 5; index <= n; index++){
            //2나 3으로 나누어지지 않는 경우
            if(index % 2 != 0 || index % 3 != 0) {
                temp= 1 + overlap[index - 1];
                overlap[index] = temp;
            }
            //3으로 나누어지는 경우
            if(index % 3 == 0) {
                temp = 1 + overlap[index / 3];
                //위에서 계산된 횟수가 최소가 아닐 경우
                if(overlap[index] > 0 && overlap[index] >temp)
                    overlap[index] = temp;
                //아직 계산되지 않은 경우
                else if(overlap[index] == 0)
                    overlap[index] = temp;
            }
            if(index % 2 == 0) {
                temp = 1 + overlap[index / 2];
                //위에서 계산된 횟수가 최소가 아닐 경우
                if(overlap[index] > 0 && overlap[index] >temp)
                    overlap[index] = temp;
                    //아직 계산되지 않은 경우
                else if(overlap[index] == 0)
                    overlap[index] = temp;
            }
        }

        bw.write(String.valueOf(overlap[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}