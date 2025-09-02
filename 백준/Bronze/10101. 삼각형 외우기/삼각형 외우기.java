import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int angle1 = Integer.parseInt(br.readLine());
        int angle2 = Integer.parseInt(br.readLine());
        int angle3 = Integer.parseInt(br.readLine());

        if(angle1 + angle2 + angle3 != 180)
            bw.write(String.valueOf("Error"));
        else if(angle1 == 60 && angle2 == 60 && angle3 == 60)
            bw.write(String.valueOf("Equilateral"));
        else if(angle1 == angle2 || angle1==angle3 || angle2 == angle3)
            bw.write(String.valueOf("Isosceles"));
        else
            bw.write(String.valueOf("Scalene"));


        bw.flush();
        bw.close();
        br.close();
    }
}