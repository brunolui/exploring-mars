package br.com.elo7.domain;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.elo7.exception.BeyondLimitException;

import static br.com.elo7.domain.CardinalDirection.EAST;
import static br.com.elo7.domain.CardinalDirection.NORTH;
import static br.com.elo7.domain.CardinalDirection.SOUTH;
import static br.com.elo7.domain.CardinalDirection.WEST;
import static org.junit.Assert.assertEquals;

public class SpaceProbeTest {

    private Plateau plateau;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        plateau = new Plateau(5, 5);
    }

    @Test
    public void testTurnRightCommandHeadingNorth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection(),"R");
        spaceProbe.run();

        assertEquals(EAST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingNorth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection(),"L");
        spaceProbe.run();

        assertEquals(WEST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnRightCommandHeadingSouth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, SOUTH.getDirection(),"R");
        spaceProbe.run();

        assertEquals(WEST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingSouth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, SOUTH.getDirection(),"L");
        spaceProbe.run();

        assertEquals(EAST, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnRightCommandHeadingWest() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, WEST.getDirection(),"R");
        spaceProbe.run();

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingWest() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, WEST.getDirection(),"L");
        spaceProbe.run();

        assertEquals(SOUTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnRightCommandHeadingEast() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, EAST.getDirection(),"R");
        spaceProbe.run();

        assertEquals(SOUTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testTurnLeftCommandHeadingEast() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, EAST.getDirection(),"L");
        spaceProbe.run();

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testWithoutCommandShouldNotChangeCardinalDirection() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection(), "");
        spaceProbe.run();

        assertEquals(NORTH, spaceProbe.getCardinalDirection());
    }

    @Test
    public void testUnknownCommandShouldThrowException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Command X not found");

        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection(),"X");
        spaceProbe.run();
    }

    @Test
    public void testInvalidDirectionShouldThrowException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("Direction X not found");

        new SpaceProbe(plateau, 1, 3, "X", "M");
    }

    @Test
    public void testMoveCommandHeadingNorth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, NORTH.getDirection(),"M");
        spaceProbe.run();

        assertEquals("1 4 N", spaceProbe.toString());
    }

    @Test
    public void testMoveCommandHeadingSouth() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, SOUTH.getDirection(),"M");
        spaceProbe.run();

        assertEquals("1 2 S", spaceProbe.toString());
    }

    @Test
    public void testMoveCommandHeadingEast() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, EAST.getDirection(),"M");
        spaceProbe.run();

        assertEquals("2 3 E", spaceProbe.toString());
    }

    @Test
    public void testMoveCommandHeadingWest() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 3, WEST.getDirection(),"M");
        spaceProbe.run();

        assertEquals("0 3 W", spaceProbe.toString());
    }

    @Test
    public void testMoreThanOneCommand() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 1, NORTH.getDirection(),"MRMR");
        spaceProbe.run();

        assertEquals("2 2 S", spaceProbe.toString());
    }

    @Test
    public void testAllCommands() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 0, 0, EAST.getDirection(),"MMMLMLMMRMMMLMLMMMM");
        spaceProbe.run();

        assertEquals("0 0 S", spaceProbe.toString());
    }

    @Test
    public void testFirstGivenExample() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 1, 2, NORTH.getDirection(),"LMLMLMLMM");
        spaceProbe.run();

        assertEquals("1 3 N", spaceProbe.toString());
    }

    @Test
    public void testSecondGivenExample() {
        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, EAST.getDirection(),"MMRMMRMRRM");
        spaceProbe.run();

        assertEquals("5 1 E", spaceProbe.toString());
    }

    @Test
    public void testMovingBeyondMinimumXLimitShouldValidate() {
        thrown.expect(BeyondLimitException.class);

        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, NORTH.getDirection(),"LMMMM");
        spaceProbe.run();
    }

    @Test
    public void testMovingBeyondMinimumYLimitShouldValidate() {
        thrown.expect(BeyondLimitException.class);

        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, NORTH.getDirection(),"RRMMMM");
        spaceProbe.run();
    }

    @Test
    public void testMovingBeyondPlateauLimitXShouldValidate() {
        thrown.expect(BeyondLimitException.class);

        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, NORTH.getDirection(),"RMMM");
        spaceProbe.run();
    }

    @Test
    public void testMovingBeyondPlateauLimitYShouldValidate() {
        thrown.expect(BeyondLimitException.class);

        SpaceProbe spaceProbe = new SpaceProbe(plateau, 3, 3, NORTH.getDirection(),"MMM");
        spaceProbe.run();
    }

}
