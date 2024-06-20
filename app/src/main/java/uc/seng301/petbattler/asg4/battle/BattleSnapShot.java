package uc.seng301.petbattler.asg4.battle;


/**
 * Represents a snapshot of the battle state at a specific point in time.
 * Stores the state of both the left and right teams.
 *
 */
public class BattleSnapShot{

    private Team leftTeam;
    private Team rightTeam;

    /**
     * Constructs an empty BattleSnapShot.
     */
    public BattleSnapShot() {
    }

    /**
     * Gets the left team stored in the snapshot.
     *
     * @return the left team
     */
    public Team getLeftTeam() {return leftTeam;}

    /**
     * Gets the right team stored in the snapshot.
     *
     * @return the right team
     */
    public Team getRightTeam() {
        return rightTeam;
    }

    /**
     * Sets the left team to be stored in the snapshot.
     *
     * @param leftTeam the left team to be stored
     */
    public void setLeftTeam(Team leftTeam) {this.leftTeam = leftTeam;}

    /**
     * Sets the right team to be stored in the snapshot.
     *
     * @param rightTeam the right team to be stored
     */
    public void setRightTeam(Team rightTeam) {this.rightTeam = rightTeam;}

}
