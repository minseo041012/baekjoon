import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, List<String>> member = new HashMap<>();

        // n만큼 member 입력 받기 (중복 키 값 허용)
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            // 기존 값 유지하면서 새 값 추가
            member.computeIfAbsent(age, k -> new ArrayList<>()).add(name);
        }

        // 정렬된 맵 생성
        SortedMap<Integer, List<String>> sorted = new TreeMap<>(member);

        // 원하는 형식으로 출력
        sorted.forEach((key, valueList) -> {
            try {
                for (String name : valueList) {
                    bw.write(key + " " + name + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        bw.flush();
        bw.close();
        br.close();
    }
}
