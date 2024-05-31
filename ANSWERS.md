# SENG301 Assignment 4 (2024) - Student answers

Joshua Byoungsoo Kim (bki42 , Student ID: 68493559)

## Task 1 - Identify the patterns in the code


### Pattern 1

#### What pattern is it?

Iterator pattern

#### What is its goal in the code?

This iterator pattern is used in the Super Auto Pets app to:

- When the BattleRunner(Client) is using iterator(TeamOrdering), the elements of an aggregate object(TeamOrdering)
    can be accessed sequentially without exposing its underlying representation.

#### Name of UML Class diagram attached

**YOUR ANSWER**

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

**YOUR ANSWER**

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

- encapsulate each of concrete strategies(BuffSelf, DebuffEnemy, HealBoth and HealSelf).
- make the strategies interchangeable.

#### Name of UML Class diagram attached

**YOUR ANSWER**

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

### Name of file of full UML Class diagram attached
I have chosen GamePet as Context as it does setStrategy which is getRandomAbility().
Client is BattleRunner because it does doSomething() which is useSpecialAbility()

## Task 3 - Implement new feature

### What pattern fulfils the need for the feature?

**YOUR ANSWER**

### What is its goal and why is it needed here?

**YOUR ANSWER**

### Name of UML Class diagram attached

**YOUR ANSWER**

### Mapping to GoF pattern elements

| GoF element | Code element |
| ----------- | ------------ |
|             |              |

## Task 4 - BONUS - Acceptance tests for Task 4

### Feature file (Cucumber Scenarios)

**NAME OF FEATURE FILE**

### Java class implementing the acceptance tests

**NAME OF JAVA FILE**
