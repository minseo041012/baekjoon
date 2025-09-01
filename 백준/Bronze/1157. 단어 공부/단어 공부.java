import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split("");
        HashMap<String, Integer> count = new HashMap<>();

        for(int i = 0; i < arr.length; i++){
            String upper = arr[i].toUpperCase();//출력을 대문자로 하기에 처음부터 대문자로 받기
            //알파벳이 이미 있으면 count 값만 변경
            if(count.containsKey(upper)){
                int temp = count.get(upper);
                count.replace(upper, ++temp);
            }
            else
                count.put(upper, 1);
        }
        //hashmap에서 value를 기준으로 정렬하는 방법은 list로 변경해서 collection sort함수 이용해서 정렬
        List<String> list = new ArrayList<>(count.keySet());
        Collections.sort(list, (value1, value2) -> count.get(value2).compareTo(count.get(value1)));
        int max = 0;
        int i = 0;
        String temp = "";

        for(String key : list){
            //1개의 알파벳만 있으면 출력 후 탈출
            if(list.size() == 1) {
                bw.write(String.valueOf(key));
                break;
            }
            //빈도 수가 같은 개 여러 개인 경우
            if(i == 1 && max == count.get(key)) {
                bw.write(String.valueOf("?"));
                break;
            }
            //가장 많이 사용된 알파벳 출력
            else if(i == 1 && max > count.get(key)) {
                bw.write(String.valueOf(temp));
                break;
            }
            i++;
            max = count.get(key);
            temp = key;//이전 알파벳을 저장
        }

        bw.flush();
        bw.close();
        br.close();
    }
}