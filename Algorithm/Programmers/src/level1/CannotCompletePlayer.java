package level1;

import java.util.HashMap;
import java.util.Map;

// 프로그래머스는 최신 자바 버전을 유지중이라고한다.
// 가끔 자바 1.8로도 풀어야겠다.
public class CannotCompletePlayer {
    private static final int FINAL_POSITION = 0;

    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        System.out.println(solution(participant, completion));
        System.out.println(solution1(participant, completion));
    }

    private static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> maps = new HashMap<>();

        for (String player : participant) {
            maps.put(player, 0);
        }

        for (String player : participant) {
            maps.put(player, maps.get(player) + 1);
        }

        for (String player : completion) {
            maps.put(player, maps.get(player) - 1);
        }

        for (Map.Entry<String, Integer> entry : maps.entrySet()) {
            if (entry.getValue() != 0) {
                answer = entry.getKey();
                break;
            }
        }

        return answer;
    }

    private static String solution1(String[] participant, String[] completion) {
        Map<String, Integer> maps = new HashMap<>();

        for (String player : participant) {
            maps.put(player, maps.getOrDefault(player, 0) + 1);
        }

        for (String player : completion) {
            maps.put(player, maps.get(player) - 1);
        }

        return maps.entrySet().stream()
                .filter((map) -> isNotComplete(map.getValue()))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(NotFoundInCompletePlayer::new);
    }

    private static boolean isNotComplete(Integer value) {
        return value != FINAL_POSITION;
    }

    static class NotFoundInCompletePlayer extends RuntimeException {
        private static final String MESSAGE = "완주자를 찾을 수 없습니다.";

        public NotFoundInCompletePlayer() {
            super(MESSAGE);
        }
    }
}
