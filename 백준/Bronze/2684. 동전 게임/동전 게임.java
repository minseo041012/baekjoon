import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            int[] coin = new int[8];
            String[] arr = br.readLine().split("");

            for(int j = 0; j < arr.length - 2; j++){
                //뒤뒤뒤
                if(arr[j].equals("T") && arr[j + 1].equals("T") && arr[j + 2].equals("T"))
                    coin[0]++;
                //뒤뒤앞
                else if(arr[j].equals("T") && arr[j + 1].equals("T") && arr[j + 2].equals("H"))
                    coin[1]++;
                //뒤앞뒤
                else if(arr[j].equals("T") && arr[j + 1].equals("H") && arr[j + 2].equals("T"))
                    coin[2]++;
                //뒤앞앞
                else if(arr[j].equals("T") && arr[j + 1].equals("H") && arr[j + 2].equals("H"))
                    coin[3]++;
                //앞뒤뒤
                else if(arr[j].equals("H") && arr[j + 1].equals("T") && arr[j + 2].equals("T"))
                    coin[4]++;
                //앞뒤앞
                else if(arr[j].equals("H") && arr[j + 1].equals("T") && arr[j + 2].equals("H"))
                    coin[5]++;
                //앞앞뒤
                else if(arr[j].equals("H") && arr[j + 1].equals("H") && arr[j + 2].equals("T"))
                    coin[6]++;
                //앞앞앞
                else if(arr[j].equals("H") && arr[j + 1].equals("H") && arr[j + 2].equals("H"))
                    coin[7]++;
            }
            for(int j = 0; j < 8; j++)
                sb.append(coin[j]).append(" ");
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}