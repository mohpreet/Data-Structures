package day7.leader.board.impl2;

import java.time.LocalDateTime;

abstract class Player {
    private Integer playerId;
    private LocalDateTime localDateTime;

    public Player(Integer playerId, LocalDateTime localDateTime) {
        this.playerId = playerId;
        this.localDateTime = localDateTime;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
class Batsman extends Player{
    private Integer score;

    public Batsman(Integer playerId , Integer score, LocalDateTime localDateTime) {
        super(playerId, localDateTime);
        this.score = score;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Batsman{" +
                "score=" + score +
                '}';
    }
}
class Bowler extends Player{
    public Bowler(Integer playerId,  Integer numberOfWickets, LocalDateTime localDateTime) {
        super(playerId, localDateTime);
        this.numberOfWickets = numberOfWickets;
    }

    private Integer numberOfWickets;

    public Integer getNumberOfWickets() {
        return numberOfWickets;
    }

    public void setNumberOfWickets(Integer numberOfWickets) {
        this.numberOfWickets = numberOfWickets;
    }

    @Override
    public String toString() {
        return "Bowler{" +
                "numberOfWickets=" + numberOfWickets +
                '}';
    }
}
