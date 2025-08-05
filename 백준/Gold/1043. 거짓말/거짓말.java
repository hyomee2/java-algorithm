import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer st;
    static int[] tNum; // 진실을 아는 사람들의 번호를 담는 배열
    static int[] parent;
    static ArrayList<Integer>[] pNum;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        st = new StringTokenizer(br.readLine(), " ");
        int numOfTrueP = Integer.parseInt(st.nextToken()); // 진실을 아는 사람의 수
        
        if (numOfTrueP == 0) { // 진실을 아는 사람이 없으면 모든 파티 참가 가능
            sb.append(M);
        } else {
            tNum = new int[numOfTrueP];

            // parent 배열 초기화
            for (int i = 1; i <= N; i++ ) {
                parent[i] = i;
            }

            // 진실을 알고 있는 사람들은 같은 집합으로 묶음
            for (int i = 0; i < numOfTrueP; i++) {
                tNum[i] = Integer.parseInt(st.nextToken());
                for (int j = 1; j < numOfTrueP; j++) {
                    union(tNum[0], tNum[j]);
                }
            }

            pNum = new ArrayList[M];

            for (int i = 0; i < M; i++) {
                pNum[i] = new ArrayList<>();
            }

            // 파티 참여를 기준으로 union
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int numOfPartyP = Integer.parseInt(st.nextToken());

                for (int j = 0; j < numOfPartyP; j++) {
                    pNum[i].add(Integer.parseInt(st.nextToken()));
                }

                for (int j = 1; j < numOfPartyP; j++) {
                    union(pNum[i].get(0), pNum[i].get(j));
                }
            }

            // 경로압축
            for (int i = 1; i <= N; i++) {
                parent[i] = find(i);
            }

            for (int i = 0; i < M; i++) {
                int size = pNum[i].size();
                for (int j = 0; j < size; j++) {
                    int node = pNum[i].get(j);
                    if (parent[tNum[0]] != parent[node]) {
                        count++;
                    }
                    break; // 이미 참여할 수 없는 파티임이 판정되면 해당 파티는 더이상 체크할 필요없음
                }
            }

            sb.append(count);
        }

        System.out.println(sb);
    }

    public static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public static int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
}