package uc.seng301.petbattler.asg4.battle;

import java.util.LinkedList;

/**
 * Manages the history of battle states, allowing for undo and redo functionality.
 *
 */
public class BattleCareTaker {

    private final LinkedList<BattleSnapShot> pastMoments;

    private final LinkedList<BattleSnapShot> momentsToDo;

    private BattleSnapShot currentBattle;


    /**
     * Constructs a new BattleCareTaker.
     * Initializes the lists for storing past and future battle states.
     */
    public BattleCareTaker() {
        pastMoments = new LinkedList<BattleSnapShot>();
        momentsToDo = new LinkedList<BattleSnapShot>();
    }

    /**
     * Save the current battle state.
     *
     * @param battleSnapShot the battle snapshot to be saved
     */
    public void saveBattle(BattleSnapShot battleSnapShot) {
        pastMoments.addLast(battleSnapShot);
        currentBattle = battleSnapShot;
        momentsToDo.clear();
    }

    /**
     * Undo the last battle state change and returns the previous state.
     *
     * @return the previous battle snapshot
     */
    public BattleSnapShot undoBattle() {
        momentsToDo.addLast(pastMoments.removeLast());
        currentBattle = pastMoments.getLast();
        return currentBattle;
    }

    /**
     * Redo the next battle state change and returns the next state.
     *
     * @return the next battle snapshot
     */
    public BattleSnapShot redoBattle() {
        currentBattle = momentsToDo.removeLast();
        pastMoments.addLast(currentBattle);
        return currentBattle;
    }
    /**
     * Checks if there is a previous battle state to undo to.
     *
     * @return true if there is a previous state, otherwise false
     */
    public boolean hasUndo() {
        return pastMoments.size() > 1;
    }

    /**
     * Checks if there is a future battle state to redo to.
     *
     * @return true if there is a future state, otherwise false
     */
    public boolean hasRedo() { return !momentsToDo.isEmpty();}

}
