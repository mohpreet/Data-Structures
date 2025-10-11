package day7.leader.board.impl2;

import java.util.*;

public enum LeaderBoard {
    INSTANCE;

    @SuppressWarnings("rawtypes")
    private final Map<LeaderBoardType, PriorityQueue> map = new HashMap<>();

    public <T> boolean addNewLeaderBoard(Map.Entry<LeaderBoardType, PriorityQueue<T>> entry) {
        if (map.containsKey(entry.getKey())) {
            return false;
        }
        map.put(entry.getKey(), entry.getValue());
        return true;
    }

    public Optional<PriorityQueue<?>> getLeaderBoard(LeaderBoardType leaderBoardType) {
        return Optional.ofNullable(map.get(leaderBoardType));
    }

    public <T> Map.Entry<LeaderBoardType, PriorityQueue<T>> createLeaderBoardEntry(
            LeaderBoardType leaderBoardType, Comparator<T> comparator) {
        return Map.entry(leaderBoardType, new PriorityQueue<>(comparator));
    }

    public boolean addPlayersToLeaderBoard(Object player) {
        LeaderBoardType leaderBoardType = LeaderBoardAndPlayerAdaptor.getLeaderBoardType(player);
        @SuppressWarnings("unchecked")
        PriorityQueue<Object> priorityQueue = map.get(leaderBoardType);
        if (priorityQueue == null) {
            return false;
        }
        priorityQueue.offer(player);
        return true;
    }

    public void printLeaderBoard(LeaderBoardType leaderBoardType) {
        PriorityQueue<?> priorityQueue = map.get(leaderBoardType);
        if (priorityQueue == null) {
            System.out.println("Map does not have given type of the leader board");
        } else {
            PriorityQueue<?> copy = new PriorityQueue<>(priorityQueue);
            while (!copy.isEmpty()) {
                System.out.println(copy.poll());
            }
        }
    }
}
