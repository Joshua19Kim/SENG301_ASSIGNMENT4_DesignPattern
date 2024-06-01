package uc.seng301.petbattler.asg4.battle;

public class BattleSnapShot{

    private Team leftTeam;
    private Team rightTeam;
    private int roundNumber;


    public BattleSnapShot(Team leftTeam, Team rightTeam, int roundNumber) {
        this.leftTeam = leftTeam;
        this.rightTeam = rightTeam;
        this.roundNumber = roundNumber;
    }

    public Team getLeftTeam() {
        return leftTeam;
    }
    public Team getRightTeam() {
        return rightTeam;
    }
    public int getRoundNumber() {
        return roundNumber;
    }


    public void setLeftTeam(Team leftTeam) {this.leftTeam = leftTeam;}
    public void setRightTeam(Team rightTeam) {this.rightTeam = rightTeam;}
    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
