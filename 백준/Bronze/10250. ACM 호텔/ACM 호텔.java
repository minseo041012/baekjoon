import java.util.Scanner;

public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int guest = sc.nextInt();

        for(int i = 0; i < guest; i++)
        {
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            put_guest(H, W, N);
        }
        sc.close();
    }
    public static void put_guest(int H, int W, int N)
    {
        int count = 0;

        for (int i = 1; i <= W; i++)
        {
            for (int j = 1; j <= H; j++)
            {
                count++;
                if (count == N)
                {
                    System.out.println(j * 100 + i);
                    return;
                }
            }
        }
    }
}
