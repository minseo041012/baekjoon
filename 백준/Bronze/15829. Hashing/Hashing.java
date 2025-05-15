import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        String s = br.readLine();

        HashMap<String, Integer> map = new HashMap<>();
        String[] str = new String[length];
        long result = 0;
        int Mod = 1234567891;

        for(int i = 0; i < 26; i++){
            char temp = (char)('a' + i);
            //int에서 string으로 캐스팅 불가 -> char to string으로 형변환
            map.put(String.valueOf(temp) , i + 1);
        }
        //문자열 알파벳 단위로 쪼개기
        for(int i = 0; i < length; i++){
            str[i] = s.substring(i, i + 1);
        }
        //배열의 각 인덱스에 부여한 값 * 특정한 수(문제에서 제공) % Mod(문제에서 제공)
        //(A*B) mod C = ((A mod C) * (B mod C)) mod C
        long power = 1;
        for(int i = 0; i < length; i++){
            int a = map.get(str[i]);
            result = (result + a * power) % Mod;
            power = (power * 31) % Mod;
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}