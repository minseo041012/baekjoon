import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        //예외처리 해주기
        if (m > n){
            br.close();
            return ;
        }

        boolean[] prime = sieve(n,m);

        for(int i = m; i <= n; i++){
            if(prime[i])
                sb.append(i).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean[] sieve(int n, int m){
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        prime[0] = prime[1] = false;

        for (int i = 2; i <= Math.sqrt(n); i++){
            //소수라면 뒤에 오는 코드 스킵
            if(prime[i] == false)
                continue;
            //2부터 배수에 해당하는 수 true로 변경
            for(int j = i * i; j <= n; j += i)
                prime[j] = false;
        }
        return prime;
    }
}