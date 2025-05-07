import java.io.*;

public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int temp;//임시로 값 저장할 변수
        int[] end = new int[100000];
        end[0] = 1;

        for(int i = 1;;i++){
            end[i] = end[i - 1] + 6 * i;
            if(end[i] > n) {
                if (end[i - 1] == n)
                    temp = i;
                else
                    temp = i + 1;
                break;
            }
        }
        bw.write(String.valueOf(temp));

        bw.flush();
        bw.close();
        br.close();
    }
}