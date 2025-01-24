import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int numOfTestCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < numOfTestCases; i++) {
            int numOfStyles = 1;
            int num = Integer.parseInt(br.readLine());
            HashMap<String, Integer> map = new HashMap<>();

            for (int j = 0; j < num; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                
                if (map.containsKey(type)){
                    map.put(type, map.get(type) + 1);
                } else {
                    map.put(type, 1);
                }
            }

            for (String key : map.keySet()) {
                numOfStyles *= (map.get(key) + 1);
            }

            sb.append((numOfStyles - 1) + "").append('\n');
        }
        System.out.println(sb);
    }
}