import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int finger = Integer.parseInt(br.readLine());
        long repeat = Integer.parseInt(br.readLine());
        long max = finger;
        int[] arr = new int[6];
        arr[1] = 8; arr[5] = 8;
        arr[2] = 6; arr[3] = 4; arr[4] = 2;

        if(repeat == 0)
            bw.write(String.valueOf(finger - 1));
        else {
            if(finger == 1 || finger == 5)
                max += repeat * 8;
            else if(finger == 3)
                max += repeat * 4;
            else if(finger == 2)
                max += (repeat / 2) * 8 + (repeat % 2) * 6;
            else if(finger == 4)
                max += (repeat / 2) * 8 + (repeat % 2) * 2;
            bw.write(String.valueOf(max - 1));
        }


        bw.flush();
        bw.close();
        br.close();
    }
}