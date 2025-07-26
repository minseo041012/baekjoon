import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num_stair = Integer.parseInt(br.readLine());
        int[] stair = new int[num_stair + 1];

        for(int i = 1; i <= num_stair; i++)
            stair[i] = Integer.parseInt(br.readLine());

        int max = max_score(stair, num_stair);
        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
        br.close();
    }


    static int max_score(int stair[], int num_stair){
        int[] max = new int[num_stair + 1];//num_stair까지 가는 최대 점수 저장하는 배열

        max[1] = stair[1];//첫번째는 무조건 밟아야 하니까 최대값은 stair[1]
        //outofIndex 피하기 위해 조건문 설정
        if(num_stair > 1)
            max[2] = stair[1] + stair[2];//2칸 다 밟아야 최대점수

        for(int i =3; i <= num_stair; i++)
            //여기에서 stair[i-1]인 이유는 max[i-1]로 사용하게 되면 연속 3칸을 전부 다 밟아 조건에 어긋나기 때문
            max[i] = Math.max(max[i - 2], stair[i - 1] + max[i - 3]) + stair[i];

        return max[num_stair];
    }
}