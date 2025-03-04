import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int kg = Integer.parseInt(br.readLine());
        int count = -1;
        int temp;

        for (int i = kg / 5; i >= 0; i--){
            temp = kg - (5 * i);
            if (temp % 3 == 0)
            {
                count = i + (temp / 3);
                break;
            }
        }
        if (kg % 3 == 0 && count == -1)
            count = kg / 3;

        bw.write(String.valueOf(count));

        bw.flush();
        br.close();
        bw.close();
    }
}
