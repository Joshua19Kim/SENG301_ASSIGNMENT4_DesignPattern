# SENG301 Assignment 4 (2024) - Student answers

Joshua Byoungsoo Kim (bki42 , Student ID: 68493559)


NOTE : In diagram, FINAL attribute is shown in Capital letters (Reference link below)
Reference - https://stackoverflow.com/questions/47588511/uml-diagram-how-to-show-final

## Task 1 - Identify the patterns in the code


### Pattern 1

#### What pattern is it?

Iterator pattern

#### What is its goal in the code?

This iterator pattern is used in the Super Auto Pets app to:

- When the BattleRunner(Client) is using iterator(TeamOrdering), the elements of an aggregate object(TeamOrdering)
    can be accessed sequentially without exposing its underlying representation.

#### Name of UML Class diagram attached

./diagrams/sap-iterator-domain.png

Since TeamList has OrderedTeam and ReveredTeam in getOrderedTeam() and getReversedTeam(), the direct associations are applied from TeamList to OrderedTeam and ReversedTeam.
Additionally, Team is assigned in OrderedTeam and ReversedTeam, so the direct associations are applied from OrderedTeam and reversedTeam to Team

#### Mapping to GoF pattern elements

| GoF element       | Code element |
|-------------------|--------------|
| Client            | BattleRunner |
| Aggregate         | Team         |
| ConcreteAggregate | TeamList     |
| Iterator          | TeamOrdering |
| ConcreteIteratorA | OrderedTeam  |
| ConcreteIteratorB | ReversedTeam |


### Pattern 2

#### What pattern is it?

Prototype pattern

#### What is its goal in the code?

This prototype pattern is used in the Super Auto Pets app to:

- As this game requires creating many pets repeatedly, it is more efficient to copy the existing instance than creating new instance from scratch.

#### Name of UML Class diagram attached

./diagrams/sap-prototype-domain.png

#### Mapping to GoF pattern elements

| GoF element       | Code element |
|-------------------|--------------|
| Client            | Game         |
| Prototype         | ClonablePet  |
| ConcretePrototype | Pet          |
| SubclassPrototype | GamePet      |
| clone()           | getGamePet() |



### Pattern 3

#### What pattern is it?

Strategy pattern

#### What is its goal in the code?

This strategy pattern is used in the Super Auto Pets app to:

- encapsulate each of concrete strategies(BuffSelf, DebuffEnemy, HealBoth and HealSelf).// we can easily add more strategy in the future.
- make the strategies interchangeable. 

#### Name of UML Class diagram attached

./diagrams/sap-strategy-domain.png

I have chosen GamePet as Context as it does setStrategy which is getRandomAbility().
Client is BattleRunner because it does doSomeThing() which is useSpecialAbility().

#### Mapping to GoF pattern elements

| GoF element       | Code element      |
|-------------------|-------------------|
| Client            | BattleRunner      |
| Context           | GamePet           |
| Strategy          | SpecialAbility    |
| ConcreteStrategyA | BuffSelf          |
| ConcreteStrategyB | HealSelf          |
| ConcreteStrategyC | HealBoth          |
| ConcreteStrategyD | DebuffEnemy       |
| Algorithm         | useSpecialAbility |

## Task 2 - Full UML Class diagram

./diagrams/sap-my-domain.png


## Task 3 - Implement new feature

### What pattern fulfils the need for the feature?

Memento pattern

### What is its goal and why is it needed here?

The requirement is making undo/redo function in the game and the memento pattern provides 
the ability to restore an object to its previous state.
Therefore, the user can move backward to the previous round(s) if he/she has played at least once, 
also can move forward to the undone round.

### Name of UML Class diagram attached

./diagrams/sap-memento-domain.png

createMemento() is in setMemento() which is saveBattleSnapShot() for the tidiness of the code.

### Mapping to GoF pattern elements

| GoF element  | Code element                      |
|--------------|-----------------------------------|
| Originator   | BattleRunner                      |
| Memento      | BattleSnapShot                    |
| Caretaker    | BattleCareTaker                   |
| getStateA()  | BattleSnapShot.getLeftTeam()      |
| getStateB()  | BattleSnapShot.getRightTeam()     |
| setStateA()  | BattleSnapShot.setLeftTeam()      |
| setStateB()  | BattleSnapShot.setRightTeam()     |
| setMemento() | BattleRunner.saveBattleSnapshot() |


## Task 4 - BONUS - Acceptance tests for Task 4

### Feature file (Cucumber Scenarios)

**NAME OF FEATURE FILE**

### Java class implementing the acceptance tests

**NAME OF JAVA FILE**
