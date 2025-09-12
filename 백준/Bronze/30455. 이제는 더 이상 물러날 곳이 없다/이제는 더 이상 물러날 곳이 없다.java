import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int duck = 1;
        int goose = n;

        while(duck != goose){
            if(++duck == goose)
                bw.write(String.valueOf("Duck"));
            else if(--goose == duck)
                bw.write(String.valueOf("Goose"));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}