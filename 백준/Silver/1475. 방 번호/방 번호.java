import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> count = new HashMap<>();
        int num = Integer.parseInt(br.readLine());
        int result = 0;

        //각 수가 몇 번 등장했는지
        while(num != 0){
            int temp = num % 10;
            if(count.containsKey(temp))
                count.replace(temp, count.get(temp) + 1);
            else
                count.put(temp, 1);
            num /= 10;
        }

        //6과 9는 뒤집어서 사용할 수 있기 때문에 따로 예외처리하기
        if(count.containsKey(6) && count.containsKey(9)){
            result = (count.get(6) + count.get(9)) / 2 + (count.get(6) + count.get(9)) % 2;
        }
        else if(count.containsKey(6))
            result = count.get(6) / 2 + count.get(6) % 2;
        else if(count.containsKey(9))
            result = count.get(9) / 2 + count.get(9) % 2;

        //예외 처리 후, 6과 9를 제외한 나머지 숫자들의 개수 비교하기
        for (Integer key : count.keySet()) {
            if(key != 6 && key != 9){
                if(count.get(key) > result)
                    result = count.get(key);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}