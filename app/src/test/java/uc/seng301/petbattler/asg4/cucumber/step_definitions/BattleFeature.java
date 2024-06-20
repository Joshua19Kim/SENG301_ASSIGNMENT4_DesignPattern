package uc.seng301.petbattler.asg4.cucumber.step_definitions;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import uc.seng301.petbattler.asg4.Game;
import uc.seng301.petbattler.asg4.accessor.PackAccessor;
import uc.seng301.petbattler.asg4.accessor.PetAccessor;
import uc.seng301.petbattler.asg4.accessor.PlayerAccessor;
import uc.seng301.petbattler.asg4.battle.TeamList;
import uc.seng301.petbattler.asg4.cli.CommandLineInterface;
import uc.seng301.petbattler.asg4.model.Pack;
import uc.seng301.petbattler.asg4.model.Pet;
import uc.seng301.petbattler.asg4.model.Player;
import uc.seng301.petbattler.asg4.pets.PetGenerator;
import uc.seng301.petbattler.asg4.pets.PetService;

import java.util.*;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BattleFeature {
    private static PlayerAccessor playerAccessor;
    private static PackAccessor packAccessor;
    private static PetAccessor petAccessor;
    private static PetGenerator petGeneratorSpy;
    public static int petIncrement = 0;

    private static List<String> output;
    private static Game game;
    private static Runnable doLater;
    public static Queue<String> mockedInputQueue;

    @BeforeAll
    public static void before_or_after_all() {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        playerAccessor = new PlayerAccessor(sessionFactory);
        packAccessor = new PackAccessor(sessionFactory);
        petAccessor = new PetAccessor(sessionFactory);

        petGeneratorSpy = Mockito.spy(new PetService());

        CommandLineInterface cli = Mockito.mock(CommandLineInterface.class);
        game = new Game(petGeneratorSpy, cli, sessionFactory);

        HashMap<String, TeamList> teams = new HashMap<>();

        mockedInputQueue = new LinkedList<>();
        mockedInputQueue.add("");

        Mockito.when(cli.getNextLine()).thenAnswer(i -> {
            if (mockedInputQueue.isEmpty()) {return "";}
            String response = mockedInputQueue.poll();
            System.out.println("mocked input provided: " + response);
            return response;
        });

        output = new ArrayList<>();
        Mockito.doAnswer((i) -> {
            output.add(i.getArgument(0));
            System.out.println((String) i.getArgument(0));
            return null;
        }).when(cli).printLine(Mockito.anyString());
    }


    @When("I, {string}, build two teams with {string} named {string} and {string}")
    public void i_build_two_teams_with_named_and(String playerName, String packName, String firstTeamName, String secondTeamName) {

        Player player = playerAccessor.getPlayerByName(playerName);
        Pack testPack = packAccessor.getPackByPlayerNameAndPackName(playerName, packName);

        mockedInputQueue.add("0 1 2");
        game.buildTeam("build_team " + playerName + " " + packName+ " " + firstTeamName);

        mockedInputQueue.add("1 3 4");
        game.buildTeam("build_team " + playerName + " " + packName + " " + secondTeamName);
    }

    @When("I start a battle with {string} and {string}")
    public void i_start_a_battle_with_and(String firstTeam, String secondTeam) {
        doLater = () -> game.battle("battle "+ firstTeam + " " + secondTeam);

    }

    @Then("the battle should successfully start")
    public void the_battle_should_successfully_start() {
        doLater.run();
        Assertions.assertTrue(output.stream()
                .anyMatch(line -> line.contains("Starting Battle: ")));
    }


//    @When("the battle lasts for more than {int} rounds")
//    public void the_battle_lasts_for_more_than_rounds(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("the battle should end in a draw")
//    public void the_battle_should_end_in_a_draw() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("one team loses all their pets")
//    public void one_team_loses_all_their_pets() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("the other team should win the battle")
//    public void the_other_team_should_win_the_battle() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }


}
