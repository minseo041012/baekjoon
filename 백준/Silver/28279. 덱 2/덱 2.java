import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> de = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            String[] temp = br.readLine().split(" ");
            //정수 x를 덱의 앞에 넣는다
            if(Integer.parseInt(temp[0]) == 1)
                de.addFirst(Integer.parseInt(temp[1]));
            //정수 x를 덱의 맨 뒤에 넣는다
            else if(Integer.parseInt(temp[0]) == 2)
                de.addLast(Integer.parseInt(temp[1]));
            //덱에 정수가 있다면 맨 앞의 정수를 빼고 출력, 없으면 -1
            else if(Integer.parseInt(temp[0]) == 3){
                if(de.isEmpty())
                    sb.append(-1);
                else
                    sb.append(de.pollFirst());
                sb.append("\n");
            }
            //덱에 정수가 있으면 맨 뒤의 정수를 빼고 출력, 없으면 -1
            else if(Integer.parseInt(temp[0]) == 4){
                if(de.isEmpty())
                    sb.append(-1);
                else
                    sb.append(de.pollLast());
                sb.append("\n");
            }
            //덱의 사이즈 출력
            else if(Integer.parseInt(temp[0]) == 5)
                sb.append(de.size()).append("\n");
            //덱이 비어있으면 1, 아니면 0
            else if(Integer.parseInt(temp[0]) == 6){
                if(de.isEmpty())
                    sb.append(1);
                else
                    sb.append(0);
                sb.append("\n");
            }
            //맨 앞 정수 출력, 없으면 -1
            else if(Integer.parseInt(temp[0]) == 7){
                if(de.isEmpty())
                    sb.append(-1);
                else
                    sb.append(de.peekFirst());
                sb.append("\n");
            }
            //맨 뒤 정수 출력, 없으면 -1
            else if(Integer.parseInt(temp[0]) == 8){
                if(de.isEmpty())
                    sb.append(-1);
                else
                    sb.append(de.peekLast());
                sb.append("\n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}