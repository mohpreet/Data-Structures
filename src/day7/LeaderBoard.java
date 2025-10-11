package day7;

import java.util.*;

public enum LeaderBoard {
    INSTANCE;
    private Map<LeaderBoardType, PriorityQueue<Player>> map = new HashMap<>();

    public boolean addNewLeaderBoard(Map.Entry<LeaderBoardType, PriorityQueue<Player>> entry) {
        boolean ret = true;
        if (map.containsKey(entry.getKey())) {
            ret = false;
        } else {
            map.put(entry.getKey(), entry.getValue());
        }
        return ret;
    }

    public Optional<PriorityQueue<Player>> getLeaderBoard(LeaderBoardType leaderBoardType) {
        return Optional.of(map.get(leaderBoardType));
    }

    public Map.Entry<LeaderBoardType, PriorityQueue<Player>> createLeaderBoardEntry(LeaderBoardType leaderBoardType) {
        return Map.entry(leaderBoardType, new PriorityQueue<>(SCORE_DESC_THEN_TIME_ASC));
    }

    public boolean addPlayersToLeaderBoard(LeaderBoardType leaderBoardType, Player player) {
        boolean ret = true;
        PriorityQueue<Player> priorityQueue = map.get(leaderBoardType);
        if (Objects.isNull(priorityQueue)) {
            ret = false;
        } else {
            priorityQueue.offer(player);
        }
        return ret;
    }

    public void printLeaderBoard(LeaderBoardType leaderBoardType) {
        PriorityQueue<Player> priorityQueue = map.get(leaderBoardType);
        if (Objects.isNull(priorityQueue)) {
            System.out.println("Map does not have given type of the leader board");
        } else {
            PriorityQueue<Player> newPQ = new PriorityQueue<>(priorityQueue);
            while (!newPQ.isEmpty()) {
                System.out.println(newPQ.poll());
            }
        }
    }

    private static final Comparator<Player> SCORE_DESC_THEN_TIME_ASC =
            Comparator.comparing((Player p) -> p.score(), Comparator.reverseOrder())  // descending score
                    .thenComparing((Player p) -> p.localDateTime());

    /**
     * Exploded Code
     * import java.util.Comparator;
     *
     * public class PlayerComparators {
     *
     *     public static final Comparator<Player> SCORE_DESC_THEN_TIME_ASC = new Comparator<Player>() {
     *         @Override
     *         public int compare(Player p1, Player p2) {
     *
     *             // 1️⃣ Compare score (Descending)
     *             if (p1.score() > p2.score()) {
     *                 return -1; // p1 should come first
     *             } else if (p1.score() < p2.score()) {
     *                 return 1;  // p2 should come first
     *             }
     *
     *             // 2️⃣ If score is same → compare time (Ascending)
     *             if (p1.localDateTime().isBefore(p2.localDateTime())) {
     *                 return -1;
     *             } else if (p1.localDateTime().isAfter(p2.localDateTime())) {
     *                 return 1;
     *             } else {
     *                 return 0; // Both same
     *             }
     *         }
     *     };
     * }
     * */

}
