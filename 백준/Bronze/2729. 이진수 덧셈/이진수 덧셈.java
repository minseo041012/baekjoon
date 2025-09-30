import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int test = Integer.parseInt(br.readLine());

        for(int i = 0; i < test; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String[] a = st.nextToken().split("");
            String[] b = st.nextToken().split("");

            int idx_a = a.length - 1;//a 배열 인덱스
            int idx_b = b.length - 1;//b 배열 인덱스
            int up = 0;//올림 해야하는 지 확인
            String result = "";//결과 저장

            //a b 둘 중 하나의 배열이 0이 될때까지 반복문 돌기
            while(idx_a >= 0 && idx_b >= 0){
                int temp = Integer.parseInt(a[idx_a]) + Integer.parseInt(b[idx_b]) + up;

                //더했을 때, 1인 경우
                if(temp % 2 == 1) {
                    //3일 경우, 올림을 해야하기에 up 1로 업데이트
                    if(temp > 2)
                        up = 1;
                    else
                        up = 0;
                    result = String.valueOf(1) + result;//결과 저장
                }
                //더했을 때, 0인 경우
                else{
                    //2일 경우, 올림을 해야하기에 up 1로 업데이트
                    if(temp > 1)
                        up = 1;
                    else
                        up = 0;
                    result = String.valueOf(0) + result;//결과 저장
                }
                idx_a--;
                idx_b--;
            }
            //a 배열 아직 남은 경우
            if(idx_a >= 0){
                while(idx_a >= 0) {
                    int temp = Integer.parseInt(a[idx_a]) + up;
                    if (temp % 2 == 1) {
                        if (temp > 2)
                            up = 1;
                        else
                            up = 0;
                        result = String.valueOf(1) + result;
                    } else {
                        if (temp > 1)
                            up = 1;
                        else
                            up = 0;
                        result = String.valueOf(0) + result;
                    }
                    idx_a--;
                }
            }
            //b 배열 아직 남은 경우
            else if(idx_b >= 0){
                while(idx_b >= 0) {
                    int temp = Integer.parseInt(b[idx_b]) + up;
                    if (temp % 2 == 1) {
                        if (temp > 2)
                            up = 1;
                        else
                            up = 0;
                        result = String.valueOf(1) + result;
                    } else {
                        if (temp > 1)
                            up = 1;
                        else
                            up = 0;
                        result = String.valueOf(0) + result;
                    }
                    idx_b--;
                }
            }
            //마지막 올림까지 확인
            if(up == 1)
                result = String.valueOf(1) + result;

            //1부터 시작하도록 설정
            //0001이면 1만 나오도록. 0000이면 0만 나오도록 설정
            while(result.length() > 1){
                if(result.charAt(0) == '0')
                    result = result.substring(1);
                else
                    break;
            }
            sb.append(result).append("\n");
        }


        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}