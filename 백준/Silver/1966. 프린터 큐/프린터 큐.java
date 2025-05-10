import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testcase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testcase; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Deque<value> qu = new LinkedList<>();
            int arr[] = new int[n];
            int count = 0;
            int id = 0;
            int va = 0;

            st = new StringTokenizer(br.readLine());
            //n이 1이면 1출력 후 계속
            if(n == 1){
                bw.write(String.valueOf(1) + "\n");
                continue;
            }
            //qu에 우선순위 값 저장
            for(int j = 0; j < n; j++){
                int temp = Integer.parseInt(st.nextToken());
                qu.add(new value(temp, j));
                arr[j] = temp;
            }
            //오름차순으로 정렬
            Arrays.sort(arr);

            for (;;){
                //max값 맨 앞에 위치시키기
                for(;;){
                    id = qu.peek().index;
                    va = qu.peek().priority;
                    //최댓값이 같은 경우
                    if(arr[arr.length - count - 1] == va){
                        count++;
                        qu.pollFirst();
                        break;
                    }
                    else
                        qu.addLast(qu.pollFirst());
                }
                //값을 찾은 경우 출력 후 탈출
                if(id == m){
                    bw.write(String.valueOf(count) + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static class value{
        int priority;
        int index;

        value(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }
}