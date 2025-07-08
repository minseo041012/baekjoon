import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> password = new HashMap<String, String>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String temp1 = st.nextToken();
            String temp2 = st.nextToken();
            password.put(temp1, temp2);
        }

        for(int i =0; i< m; i++){
            String web_site = br.readLine();
            bw.write(password.get(web_site) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}