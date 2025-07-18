import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
      long result = 1;

      for(int i = n; i > 0; i--){
        result *= i;
      }
      bw.write(String.valueOf(result));
      bw.flush();
      bw.close();
      br.close();
    }
}