import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int changeMoment = 0;  // leadingTeam(이기고 있는 팀)이 바뀌는 순간
        int[] leadingSeconds = {0, 0}; // 각 팀이 이기고 있는 초
        int[] numOfGoals = {0, 0}; // 각 팀의 골수
        int leadingTeam = 0;  // 이기고 있는 팀

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int scoringTeam = Integer.parseInt(st.nextToken());
            String scoringTime = st.nextToken();

            st = new StringTokenizer(scoringTime, ":");
            int minute = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int secondsOfScoring = minute * 60 + second;  // 게임 시작부터 몇 초가 지난 시점인지

            // 아직 현재 들어간 골이 점수에 반영안됨
            if (numOfGoals[0] == numOfGoals[1]) {
                changeMoment = secondsOfScoring; // 현재 골 넣기 전까지 무승부였다면, 현재 시간을 저장
                leadingTeam = scoringTeam; // 이기고 있는 팀 업데이트
            }

            // 현재 들어간 골 점수에 반영
            numOfGoals[scoringTeam - 1]++;

            if (i == 0 || numOfGoals[0] != numOfGoals[1]) {
                if (i == num - 1) {
                    leadingSeconds[leadingTeam - 1] += 48 * 60 - changeMoment; // 만약 특정 팀이 이기고 있는 상태에서 게임이 끝났을 때의 처리
                }
            } else { // 현재 골을 넣어서 무승부가 되었다면
                leadingSeconds[leadingTeam - 1] += secondsOfScoring - changeMoment;  // 이기고 있던 팀이 몇 초동안 이기고 있었는지 넣어준다.
                leadingTeam = 0;  // 무승부가 되었으니 이기고 있는 팀이 없다. (0)
            }
        }

        for (int second : leadingSeconds) {
            String leadingMinute = second / 60 + "";
            String leadingSecond = second % 60 + "";

            // 한자리수여서 앞에 0을 붙여준다.
            if (leadingMinute.length() < 2) {
                leadingMinute = "0" + leadingMinute;
            }

            // 한자리수여서 앞에 0을 붙여준다.
            if (leadingSecond.length() < 2) {
                leadingSecond = "0" + leadingSecond;
            }

            sb.append(leadingMinute).append(":").append(leadingSecond).append("\n");
        }

        System.out.print(sb);
    }
}