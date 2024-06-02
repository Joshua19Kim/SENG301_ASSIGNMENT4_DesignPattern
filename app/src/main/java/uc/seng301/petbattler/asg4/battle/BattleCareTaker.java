package uc.seng301.petbattler.asg4.battle;

import java.util.LinkedList;

public class BattleCareTaker {

    private static LinkedList<BattleSnapShot> pastMoments;

    private static LinkedList<BattleSnapShot> momentsToDo;

    private static BattleSnapShot currentBattle;



    public BattleCareTaker() {
        pastMoments = new LinkedList<BattleSnapShot>();
        momentsToDo = new LinkedList<BattleSnapShot>();

    }

    public void saveBattle(BattleSnapShot battleSnapShot) {
        pastMoments.addLast(battleSnapShot);
        currentBattle = battleSnapShot;
    }

    public void removeFuture () {
        momentsToDo.clear();
    }
    public BattleSnapShot undoBattle() {
        momentsToDo.addLast(pastMoments.removeLast());
        currentBattle = pastMoments.getLast();
        return currentBattle;
    }

    public BattleSnapShot redoBattle() {
        currentBattle = momentsToDo.removeLast();
        pastMoments.addLast(currentBattle);
        return currentBattle;
    }

    public boolean hasUndo() {
        return pastMoments.size() > 1;
    }

    public boolean hasRedo() { return !momentsToDo.isEmpty();}

    public LinkedList<BattleSnapShot> showPast() {
        return pastMoments;
    }
    public LinkedList<BattleSnapShot> showFuture() {
        return momentsToDo;
    }



}
