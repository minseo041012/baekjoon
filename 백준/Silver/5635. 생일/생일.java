import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        LocalDate min = LocalDate.of(3000, 1, 1);
        LocalDate max = LocalDate.of(1000, 1, 1);
        String name_min ="";
        String name_max = "";

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            LocalDate date = LocalDate.of(year, month, day);

            if(i == 0){
                name_min = name;
                name_max = name;
            }
            if(min.isAfter(date)) {
                min = date;
                name_min = name;
            }
            if(max.isBefore(date)) {
                max = date;
                name_max = name;
            }
        }
        sb.append(name_max).append("\n").append(name_min);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}