package br.com.elo7.domain;

import org.junit.Before;
import org.junit.Test;

import br.com.elo7.exception.BeyondLimitException;

import static br.com.elo7.domain.CardinalDirection.EAST;
import static br.com.elo7.domain.CardinalDirection.NORTH;
import static br.com.elo7.domain.CardinalDirection.SOUTH;
import static br.com.elo7.domain.CardinalDirection.WEST;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class SpaceProbeTest {

    private Plateau plateau;

    @Before
    public void setup() {
        plateau = new Plateau(5, 5);
    }

    @Test
    public void testTurnRightCommandHeadingNorth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection());
        spaceProbe.run("R");

        assertEquals(EAST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingNorth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection());
        spaceProbe.run("L");

        assertEquals(WEST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnRightCommandHeadingSouth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, SOUTH.getDirection());
        spaceProbe.run("R");

        assertEquals(WEST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingSouth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, SOUTH.getDirection());
        spaceProbe.run("L");

        assertEquals(EAST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnRightCommandHeadingWest() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, WEST.getDirection());
        spaceProbe.run("R");

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingWest() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, WEST.getDirection());
        spaceProbe.run("L");

        assertEquals(SOUTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnRightCommandHeadingEast() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, EAST.getDirection());
        spaceProbe.run("R");

        assertEquals(SOUTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingEast() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, EAST.getDirection());
        spaceProbe.run("L");

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testWithoutCommandShouldNotChangeCardinalDirection() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection());
        spaceProbe.run("");

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testUnknownCommandShouldThrowException() {
        try {
            SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection());
            spaceProbe.run("X");
            fail("should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Command X not found", e.getMessage());
        }
    }

    @Test
    public void testInvalidDirectionShouldThrowException() {
        try {
            new SpaceProbe(plateau, 1, 3, "X");
            fail("should throw an exception");
        } catch (IllegalArgumentException e) {
            assertEquals("Direction X not found", e.getMessage());
        }
    }

    @Test
    public void testMoveCommandHeadingNorth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection());
        spaceProbe.run("M");

        assertEquals("1 4 N", spaceProbe.toString());
    }

    @Test
    public void testMoveCommandHeadingSouth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, SOUTH.getDirection());
        spaceProbe.run("M");

        assertEquals("1 2 S", spaceProbe.toString());
    }

    @Test
    public void testMoveCommandHeadingEast() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, EAST.getDirection());
        spaceProbe.run("M");

        assertEquals("2 3 E", spaceProbe.toString());
    }

    @Test
    public void testMoveCommandHeadingWest() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, WEST.getDirection());
        spaceProbe.run("M");

        assertEquals("0 3 W", spaceProbe.toString());
    }

    @Test
    public void testMoreThanOneCommand() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 1, NORTH.getDirection());
        spaceProbe.run("MRMR");

        assertEquals("2 2 S", spaceProbe.toString());
    }

    @Test
    public void testAllCommands() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 0, 0, EAST.getDirection());
        spaceProbe.run("MMMLMLMMRMMMLMLMMMM");

        assertEquals("0 0 S", spaceProbe.toString());
    }

    @Test
    public void testFirstGivenExample() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 2, NORTH.getDirection());
        spaceProbe.run("LMLMLMLMM");

        assertEquals("1 3 N", spaceProbe.toString());
    }

    @Test
    public void testSecondGivenExample() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, EAST.getDirection());
        spaceProbe.run("MMRMMRMRRM");

        assertEquals("5 1 E", spaceProbe.toString());
    }

    @Test(expected = BeyondLimitException.class)
    public void testMovingBeyondMinimumXLimitShouldValidate() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, NORTH.getDirection());
        spaceProbe.run("LMMMM");
    }

    @Test(expected = BeyondLimitException.class)
    public void testMovingBeyondMinimumYLimitShouldValidate() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, NORTH.getDirection());
        spaceProbe.run("RRMMMM");
    }

    @Test(expected = BeyondLimitException.class)
    public void testMovingBeyondPlateauLimitXShouldValidate() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, NORTH.getDirection());
        spaceProbe.run("RMMM");
    }

    @Test(expected = BeyondLimitException.class)
    public void testMovingBeyondPlateauLimitYShouldValidate() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, NORTH.getDirection());
        spaceProbe.run("MMM");
    }

}
