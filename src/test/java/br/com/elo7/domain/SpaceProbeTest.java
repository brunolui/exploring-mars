package br.com.elo7.domain;

import org.junit.Test;

import static br.com.elo7.domain.CardinalDirection.EAST;
import static br.com.elo7.domain.CardinalDirection.NORTH;
import static br.com.elo7.domain.CardinalDirection.SOUTH;
import static br.com.elo7.domain.CardinalDirection.WEST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SpaceProbeTest {

    @Test
    public void testTurnRightCommandHeadingNorth() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, NORTH.getDirection());
        spaceProbe.run("R");

        assertEquals(EAST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingNorth() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, NORTH.getDirection());
        spaceProbe.run("L");

        assertEquals(WEST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnRightCommandHeadingSouth() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, SOUTH.getDirection());
        spaceProbe.run("R");

        assertEquals(WEST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingSouth() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, SOUTH.getDirection());
        spaceProbe.run("L");

        assertEquals(EAST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnRightCommandHeadingWest() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, WEST.getDirection());
        spaceProbe.run("R");

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingWest() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, WEST.getDirection());
        spaceProbe.run("L");

        assertEquals(SOUTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnRightCommandHeadingEast() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, EAST.getDirection());
        spaceProbe.run("R");

        assertEquals(SOUTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingEast() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, EAST.getDirection());
        spaceProbe.run("L");

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testUnknownCommandShouldNotChangeCardinalDirection() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, NORTH.getDirection());
        spaceProbe.run("X");

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testWithoutCommandShouldNotChangeCardinalDirection() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, NORTH.getDirection());
        spaceProbe.run("");

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testInvalidDirectionShouldThrowException() throws Exception {
        try {
            new SpaceProbe(1, 3, "X");
            fail("should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Direction X not found", e.getMessage());
        }
    }

    @Test
    public void testMoveCommandHeadingNorth() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, NORTH.getDirection());
        spaceProbe.run("M");

        assertEquals("1 4 N", spaceProbe.toString());
    }

    @Test
    public void testMoveCommandHeadingSouth() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, SOUTH.getDirection());
        spaceProbe.run("M");

        assertEquals("1 2 S", spaceProbe.toString());
    }

    @Test
    public void testMoveCommandHeadingEast() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, EAST.getDirection());
        spaceProbe.run("M");

        assertEquals("2 3 E", spaceProbe.toString());
    }

    @Test
    public void testMoveCommandHeadingWest() throws Exception {
        SpaceProbe spaceProbe = new SpaceProbe(1, 3, WEST.getDirection());
        spaceProbe.run("M");

        assertEquals("0 3 W", spaceProbe.toString());
    }

}
