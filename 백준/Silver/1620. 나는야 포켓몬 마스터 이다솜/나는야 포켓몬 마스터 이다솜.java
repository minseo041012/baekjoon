import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int num_pokemon = Integer.parseInt(st.nextToken());
        int num_correction = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> pokemon = new HashMap<>();
        HashMap<String, Integer> clone = new HashMap<>();

        //포켓몬 개수만큼 입력 받아 hashmap에 put
        for(int i = 1; i <= num_pokemon; i++){
            String temp = br.readLine();
            pokemon.put(i, temp);
            clone.put(temp, i);
        }
        //num_correction만큼 반복문 돌기
        for(int i = 0; i < num_correction; i++){
            String temp = br.readLine();
            //숫자이면 이름 출력
            if(is_Integer(temp)){
                int num = Integer.parseInt(temp);
                sb.append(pokemon.get(num) + "\n");
            }
            else{
                sb.append(clone.get(temp) + "\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.close();
        br.close();
    }

    public static boolean is_Integer(String temp){
        try{
            Integer.parseInt(temp);
            return true;
        }catch(NumberFormatException ex){
            return false;
        }
    }
}