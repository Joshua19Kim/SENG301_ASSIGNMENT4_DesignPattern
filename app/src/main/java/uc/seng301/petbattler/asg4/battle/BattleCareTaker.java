package uc.seng301.petbattler.asg4.battle;

import java.util.LinkedList;

public class BattleCareTaker {

    private static LinkedList<BattleSnapShot> pastMoments;

    private static LinkedList<BattleSnapShot> momentsToDo;

    public BattleCareTaker() {
        pastMoments = new LinkedList<BattleSnapShot>();
        momentsToDo = new LinkedList<BattleSnapShot>();

    }

    public void saveBattle (BattleSnapShot currentBattle) {
        pastMoments.addLast(currentBattle);
        momentsToDo.clear();
    }
    public BattleSnapShot undoBattle() {
        BattleSnapShot nextBattle = pastMoments.removeLast();
        momentsToDo.addLast(nextBattle);
        return nextBattle;
    }

    public BattleSnapShot redoBattle() {
        BattleSnapShot nextBattle = momentsToDo.removeLast();
        pastMoments.addLast(nextBattle);
        return nextBattle;

    }

    public boolean hasUndo() { return pastMoments.isEmpty();}

    public boolean hasRedo() { return momentsToDo.isEmpty();}

}