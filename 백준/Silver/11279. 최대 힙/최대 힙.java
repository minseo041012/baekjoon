import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //우선순위큐는 기본적으로 minHeap으로 구현되어있어 maxHeap으로 구현할 경우, Comparator.reverseOrder()을 해줘야한다
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());

            if(num == 0)
            {
                if(!maxHeap.isEmpty())
                    sb.append(maxHeap.poll()).append("\n");
                else
                    sb.append("0").append("\n");
            }
            else
                maxHeap.add(num);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}