package day7.leader.board.impl2;

public enum LeaderBoardType {
    BOWLER("BOWLER"),
    WICKET_KEEPER("WICKET_KEEPER"),
    BATSMAN("BATSMAN");
    private  String leaderBoardType;
    private LeaderBoardType(String leaderBoardType){
        this.leaderBoardType=leaderBoardType;
    }
}
