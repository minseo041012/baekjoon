import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb= new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return - Integer.compare(o2, o1);
            }
        });

        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(br.readLine());

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