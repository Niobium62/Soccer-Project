package model.players;

import model.SoccerBall;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GoalkeeperTest {

    private Goalkeeper goalkeeper;

    @Before
    public void setUp() {
        goalkeeper = new Goalkeeper("Goalkeeper", Color.ORANGE);
    }

    @Test
    public void move() {
        goalkeeper.setPlayerPosition(new Point(15, 100));
        goalkeeper.moveLeft();
        assertEquals(15, goalkeeper.getPlayerPosition().x);
        assertEquals(100, goalkeeper.getPlayerPosition().y);

        goalkeeper.setPlayerPosition(new Point(20, 100));
        goalkeeper.moveLeft();
        assertEquals(10, goalkeeper.getPlayerPosition().x);
        assertEquals(100, goalkeeper.getPlayerPosition().y);

        goalkeeper.setPlayerPosition(new Point(550, 100));
        goalkeeper.moveRight();
        assertEquals(550, goalkeeper.getPlayerPosition().x);
        assertEquals(100, goalkeeper.getPlayerPosition().y);

        goalkeeper.setPlayerPosition(new Point(500, 100));
        goalkeeper.moveRight();
        assertEquals(510, goalkeeper.getPlayerPosition().x);
        assertEquals(100, goalkeeper.getPlayerPosition().y);

        goalkeeper.setPlayerPosition(new Point(100, 5));
        goalkeeper.moveUp();
        assertEquals(100, goalkeeper.getPlayerPosition().x);
        assertEquals(5, goalkeeper.getPlayerPosition().y);

        goalkeeper.setPlayerPosition(new Point(100, 20));
        goalkeeper.moveUp();
        assertEquals(100, goalkeeper.getPlayerPosition().x);
        assertEquals(15, goalkeeper.getPlayerPosition().y);

        goalkeeper.setPlayerPosition(new Point(100, 250));
        goalkeeper.moveDown();
        assertEquals(100, goalkeeper.getPlayerPosition().x);
        assertEquals(250, goalkeeper.getPlayerPosition().y);

        goalkeeper.setPlayerPosition(new Point(100, 200));
        goalkeeper.moveDown();
        assertEquals(100, goalkeeper.getPlayerPosition().x);
        assertEquals(205, goalkeeper.getPlayerPosition().y);
    }


    @Test
    public void shootBall() {
        SoccerBall soccerBall = SoccerBall.getSoccerBall();
        soccerBall.setPosition(new Point(20, 400));
        goalkeeper.shootBall();
        assertEquals(20, soccerBall.getPosition().x);
        assertEquals(420, soccerBall.getPosition().y);
    }

    @Test
    public void moveRandomly() {
        goalkeeper.setPlayerPosition(new Point(400, 20));
        goalkeeper.moveRandomly();
        assertTrue(goalkeeper.getPlayerPosition().x < 400);
        assertEquals(20, goalkeeper.getPlayerPosition().y);

        goalkeeper.setPlayerPosition(new Point(100, 20));
        goalkeeper.moveRandomly();
        assertTrue(goalkeeper.getPlayerPosition().x > 100);
        assertEquals(20, goalkeeper.getPlayerPosition().y);
    }

    @Test
    public void testToString() {
        goalkeeper.setPlayerStatistics(2);
        assertEquals("Goalkeeper caught 2 balls", goalkeeper.toString());
    }
}