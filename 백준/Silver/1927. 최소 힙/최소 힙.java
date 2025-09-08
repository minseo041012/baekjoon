import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        //priorQueue 내부적으로 최소 힙(min-heap) 구현되어있음
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return - Integer.compare(o2, o1);
            }
        });
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        //위의 코드도 가능

        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(br.readLine());

            //0이 들어오면 가장 작은 값을 출력 -> 가장 작은 값=우선순위 높음
            if(input == 0) {
                if(minHeap.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(minHeap.poll()).append("\n");
            }
            else{
                minHeap.add(input);
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}