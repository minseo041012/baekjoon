import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double b = Double.parseDouble(st.nextToken());
        double v = Double.parseDouble(st.nextToken());
        int day = (int)Math.ceil((v - a) / (a -b));

        bw.write(String.valueOf(day + 1));
        bw.flush();
        bw.close();
        br.close();
    }
}