import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        BigInteger temp = new BigInteger("1"); //num이 500이하의 숫자이기에 int를 사용하면 int 값의 범위를 넘어간다
        int count = 0;

        //팩토리얼 temp에 값 넣기
        for(int i = 2; i <= num; i++){
            BigInteger b = new BigInteger(String.valueOf(i));
            temp = temp.multiply(b);
        }
        BigInteger b = new BigInteger("10");

        for(int i = 0; i < num; i++){
            //일의 자리 숫자부터 0인지 판별
            if (temp.remainder(b).compareTo(BigInteger.valueOf(0)) == 0){
                count++;
                temp = temp.divide(b);
            }
            else
                break;
        }
        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
        br.close();
    }
}