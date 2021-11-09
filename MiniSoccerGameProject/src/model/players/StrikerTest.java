package model.players;

import model.SoccerBall;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class StrikerTest {

    private Striker striker;

    @Before
    public void setUp() {
        striker = new Striker("Striker", Color.BLUE);
    }

    @Test
    public void move() {
        striker.setPlayerPosition(new Point(10, 300));
        striker.moveLeft();
        assertEquals(10, striker.getPlayerPosition().x);
        assertEquals(300, striker.getPlayerPosition().y);

        striker.setPlayerPosition(new Point(20, 300));
        striker.moveLeft();
        assertEquals(15, striker.getPlayerPosition().x);
        assertEquals(300, striker.getPlayerPosition().y);

        striker.setPlayerPosition(new Point(560, 300));
        striker.moveRight();
        assertEquals(560, striker.getPlayerPosition().x);
        assertEquals(300, striker.getPlayerPosition().y);

        striker.setPlayerPosition(new Point(500, 300));
        striker.moveRight();
        assertEquals(505, striker.getPlayerPosition().x);
        assertEquals(300, striker.getPlayerPosition().y);

        striker.setPlayerPosition(new Point(200, 100));
        striker.moveUp();
        assertEquals(200, striker.getPlayerPosition().x);
        assertEquals(100, striker.getPlayerPosition().y);

        striker.setPlayerPosition(new Point(200, 250));
        striker.moveUp();
        assertEquals(200, striker.getPlayerPosition().x);
        assertEquals(245, striker.getPlayerPosition().y);

        striker.setPlayerPosition(new Point(200, 600));
        striker.moveDown();
        assertEquals(200, striker.getPlayerPosition().x);
        assertEquals(600, striker.getPlayerPosition().y);

        striker.setPlayerPosition(new Point(200, 400));
        striker.moveDown();
        assertEquals(200, striker.getPlayerPosition().x);
        assertEquals(405, striker.getPlayerPosition().y);
    }


    @Test
    public void shootBall() {
        SoccerBall soccerBall = SoccerBall.getSoccerBall();
        soccerBall.setPosition(new Point(400, 400));
        striker.shootBall();
        assertEquals(400, soccerBall.getPosition().x);
        assertEquals(340, soccerBall.getPosition().y);
    }

    @Test
    public void grabsBall() {
        striker.setPlayerPosition(new Point(200, 300));
        SoccerBall soccerBall = SoccerBall.getSoccerBall();

        soccerBall.setPosition(new Point(205, 500));
        striker.grabsBall();
        assertEquals(190, soccerBall.getPosition().x);
        assertEquals(355, soccerBall.getPosition().y);

        soccerBall.setPosition(new Point(250, 300));
        striker.grabsBall();
        assertEquals(220, soccerBall.getPosition().x);
        assertEquals(355, soccerBall.getPosition().y);
    }


    @Test
    public void testToString() {
        striker.setPlayerStatistics(1);
        assertEquals(Color.BLUE, striker.getPlayerColor());
        assertEquals("Striker scored 1 goals", striker.toString());
    }
}