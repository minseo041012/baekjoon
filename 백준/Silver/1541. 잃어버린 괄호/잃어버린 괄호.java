import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer formula = new StringTokenizer(br.readLine(), "+/-", true);
        int result = 0;

        while(formula.hasMoreTokens()){
            String token = formula.nextToken();
            //-가 나오면 다음 -가 나오거나 식이 끝날때까지 나오는 숫자를 모두 더해서 빼주기
            if(token.equals("-")){
                int temp = 0;
                while(formula.hasMoreTokens()){
                    token = formula.nextToken();
                    /*if(token.equals("-"))
                        break;*/
                    if(!token.equals("+") && !token.equals("-"))
                        temp += Integer.parseInt(token);
                }
                result += (temp * -1);
            }
            else if(token.equals("+"))
                continue;
            else
                result += Integer.parseInt(token);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}