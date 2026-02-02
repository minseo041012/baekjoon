import java.io.*;
import java.util.*;

public class Main{
    static int white = 0, blue= 0;
    static int[][] arr;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());//크기
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide_conquer(0, 0, n);
        System.out.println(white);
        System.out.println(blue);
        br.close();
    }

    //4사분면으로 나눠서 하나씩 검사
    static void divide_conquer(int row, int col, int size){
        if(check_color(row, col, size)) {
            if(arr[row][col] == 0)
                white++;
            else
                blue++;
            return;
        }

        int new_size = size / 2;

        divide_conquer(row, col, new_size);//2사분면
        divide_conquer(row, col + new_size, new_size);//1사분면
        divide_conquer(row + new_size, col, new_size);//3사분면
        divide_conquer(row + new_size, col + new_size, new_size);//4사분면

    }

    static boolean check_color(int row, int col, int size){

        int color = arr[row][col];//첫 컬러를 color에 저장

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                //색이 다르면 바로 나감
                if(arr[i][j] != color){
                    return false;
                }
            }
        }
        return true;
    }
}