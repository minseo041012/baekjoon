import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> a = new HashSet<>();
        for(int i = 0; i< n; i++)
            a.add(Integer.parseInt(st.nextToken()));

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++){
            int temp = Integer.parseInt(st.nextToken());
            if (a.contains(temp))
                bw.write(1 + "\n");
            else
                bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}