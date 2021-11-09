package model;

import model.SoccerBall;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class SoccerBallTest {

    private SoccerBall soccerBall = SoccerBall.getSoccerBall();

    @Before
    public void setUp() {
        soccerBall.resetSoccerBall();
    }

    @Test
    public void getSoccerBall() {
        assertEquals(480, soccerBall.getPosition().x);
        assertEquals(500, soccerBall.getPosition().y);
        assertEquals(Color.white, soccerBall.getColor());
    }

    @Test
    public void moveBall() throws InterruptedException {
        soccerBall.moveBall(4, 6, 2);
        Thread.sleep(TimeUnit.MILLISECONDS.toMillis(500));
        assertEquals(480, soccerBall.getPosition().x);
        assertEquals(490, soccerBall.getPosition().y);
    }

    @Test
    public void moveBallY() {
        soccerBall.moveBallY(8);
        assertEquals(492, soccerBall.getPosition().y);
        soccerBall.moveBallY(18);
        assertEquals(492, soccerBall.getPosition().y);
        soccerBall.setPosition(new Point(200, 20));
        soccerBall.moveBallY(10);
        assertEquals(20, soccerBall.getPosition().y);
    }


    @Test
    public void inGate() {
        soccerBall.setPosition(new Point(200, 30));
        assertTrue(soccerBall.inGate());
        soccerBall.setPosition(new Point(150, 30));
        assertFalse(soccerBall.inGate());
        soccerBall.setPosition(new Point(500, 30));
        assertFalse(soccerBall.inGate());
        soccerBall.setPosition(new Point(200, 10));
        assertFalse(soccerBall.inGate());
        soccerBall.setPosition(new Point(200, 70));
        assertFalse(soccerBall.inGate());
    }

}