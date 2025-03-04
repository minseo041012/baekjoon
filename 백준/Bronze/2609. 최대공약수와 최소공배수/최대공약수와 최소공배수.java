import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[])
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        try {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int i;

            for(i = Math.min(n, m); i > 0; i--)
            {
                if (n % i == 0 && m % i == 0)
                {
                    bw.write(String.valueOf(i) + "\n");
                    bw.write(String.valueOf((n * m) / i));
                    break;
                }
            }
            br.close();
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
