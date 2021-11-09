package model;


import model.SoccerBall;
import model.SoccerGame;
import model.players.GamePlayer;
import model.players.Striker;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;


public class SoccerGameTest {

    private SoccerGame soccerGame;

    @Before
    public void setUp() {
        soccerGame = new SoccerGame();
    }

    @Test
    public void getTimeRemaining() {
        soccerGame.setTimeRemaining(60);
        assertEquals(60, soccerGame.getTimeRemaining().intValue());
    }


    @Test
    public void getGoal() {
        soccerGame.setGoal(1);
        Integer goal = soccerGame.getGoal();
        assertEquals(1, goal.intValue());
    }


    @Test
    public void isPaused() {
        assertFalse(soccerGame.isPaused());
        soccerGame.setPaused(true);
        assertTrue(soccerGame.isPaused());
    }


    @Test
    public void isOver() {
        assertFalse(soccerGame.isOver());
        soccerGame.setOver(true);
        assertTrue(soccerGame.isOver());
    }


    @Test
    public void automateGoalkeeper() {
        GamePlayer goalkeeper = soccerGame.getGamePlayers().get("Goalkeeper");
        soccerGame.automateGoalkeeper();
        assertEquals(0, goalkeeper.getPlayerStatistics().intValue());

        SoccerBall soccerBall = SoccerBall.getSoccerBall();
        soccerBall.setPosition(new Point(200, 100));
        soccerGame.automateGoalkeeper();
        assertEquals(1, goalkeeper.getPlayerStatistics().intValue());
    }

    @Test
    public void isScored() {
        assertFalse(soccerGame.isScored());
    }

    @Test
    public void getActivePlayer() {
        GamePlayer player = soccerGame.getActivePlayer();
        assertTrue(player instanceof Striker);
    }

    @Test
    public void startGame() throws InterruptedException {
        SoccerBall soccerBall = SoccerBall.getSoccerBall();
        soccerBall.setPosition(new Point(200, 30));
        soccerGame.setTimeRemaining(0);
        Thread.sleep(TimeUnit.SECONDS.toMillis(2));
    }
}