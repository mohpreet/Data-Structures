package day7.leader.board.impl2;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class LeaderBoardTester {
    public static void main(String[] args) {
        LeaderBoard leaderBoard = LeaderBoard.INSTANCE;

        System.out.println("***Batsman Leader Board****");
        LeaderBoardTester.batsmanLeaderBoard(leaderBoard);

        System.out.println("***Bowler Leader Board******");
        LeaderBoardTester.bowlerLeaderBoard(leaderBoard);

    }

    static public void batsmanLeaderBoard(LeaderBoard leaderBoard) {

        Comparator<Batsman> SCORE_DESC_THEN_TIME_ASC =
                Comparator.comparing((Batsman p) -> p.getScore(), Comparator.reverseOrder())  // descending score
                        .thenComparing((Batsman p) -> p.getLocalDateTime());

        Map.Entry<LeaderBoardType, PriorityQueue<Batsman>> leaderBoardEntry =
                leaderBoard.<Batsman>createLeaderBoardEntry(LeaderBoardType.BATSMAN, SCORE_DESC_THEN_TIME_ASC);
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));

        leaderBoard.addNewLeaderBoard(leaderBoardEntry);
        leaderBoard.addPlayersToLeaderBoard( new Batsman(1001, 2, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(new Batsman(1002, 5, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(new Batsman(1003, 6, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(new Batsman(1004, 2, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(new Batsman(1005, 20, LocalDateTime.now()));

        leaderBoard.printLeaderBoard(LeaderBoardType.BATSMAN);
    }

    static public void bowlerLeaderBoard(LeaderBoard leaderBoard) {
        Comparator<Bowler> WICKETS_DESC_THEN_TIME_ASC =
                Comparator.comparing((Bowler p) -> p.getNumberOfWickets(), Comparator.reverseOrder())  // descending score
                        .thenComparing((Bowler p) -> p.getLocalDateTime());
        Map.Entry<LeaderBoardType, PriorityQueue<Bowler>> leaderBoardEntry =
                leaderBoard.<Bowler>createLeaderBoardEntry(LeaderBoardType.BOWLER, WICKETS_DESC_THEN_TIME_ASC);
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));

        leaderBoard.addNewLeaderBoard(leaderBoardEntry);
        leaderBoard.addPlayersToLeaderBoard(new Bowler(2001, 2, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(new Bowler(2002, 5, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(new Bowler(2003, 6, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(new Bowler(2004, 2, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(new Bowler(2005, 20, LocalDateTime.now()));

        leaderBoard.printLeaderBoard(LeaderBoardType.BOWLER);
    }
}
