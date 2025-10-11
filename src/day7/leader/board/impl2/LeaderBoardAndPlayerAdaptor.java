package day7.leader.board.impl2;

public class LeaderBoardAndPlayerAdaptor {

    public static LeaderBoardType getLeaderBoardType(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }

        if (object instanceof Batsman) {
            return LeaderBoardType.BATSMAN;
        } else if (object instanceof Bowler) {
            return LeaderBoardType.BOWLER;
        } else {
            throw new IllegalArgumentException(
                    "Unknown player type: " + object.getClass().getSimpleName());
        }
    }
}
