package day7;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.PriorityQueue;

public class LeaderBoardTester {
    public static void main(String[] args) {
        LeaderBoard leaderBoard =LeaderBoard.INSTANCE;

        System.out.println("***Batsman Leader Board****");
        LeaderBoardTester.batsmanLeaderBoard(leaderBoard);

        System.out.println("***Bowler Leader Board******");
        LeaderBoardTester.bowlerLeaderBoard(leaderBoard);

    }

    static public void batsmanLeaderBoard(LeaderBoard leaderBoard){
        Map.Entry<LeaderBoardType, PriorityQueue<Player>> leaderBoardEntry =  leaderBoard.createLeaderBoardEntry(LeaderBoardType.BATSMAN);
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));

        leaderBoard.addNewLeaderBoard(leaderBoardEntry);
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BATSMAN, new Player(1001,2, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BATSMAN, new Player(1002,5, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BATSMAN, new Player(1003,6, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BATSMAN, new Player(1004,2, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BATSMAN, new Player(1005,20, LocalDateTime.now()));

        leaderBoard.printLeaderBoard(LeaderBoardType.BATSMAN);
    }
    static public void bowlerLeaderBoard(LeaderBoard leaderBoard){
        Map.Entry<LeaderBoardType, PriorityQueue<Player>> leaderBoardEntry =  leaderBoard.createLeaderBoardEntry(LeaderBoardType.BOWLER);
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));
        System.out.println(leaderBoard.addNewLeaderBoard(leaderBoardEntry));

        leaderBoard.addNewLeaderBoard(leaderBoardEntry);
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BOWLER, new Player(2001,2, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BOWLER, new Player(2002,5, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BOWLER, new Player(2003,6, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BOWLER, new Player(2004,2, LocalDateTime.now()));
        leaderBoard.addPlayersToLeaderBoard(LeaderBoardType.BOWLER, new Player(2005,20, LocalDateTime.now()));

        leaderBoard.printLeaderBoard(LeaderBoardType.BOWLER);
    }
}
