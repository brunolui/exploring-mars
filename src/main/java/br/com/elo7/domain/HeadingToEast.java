package br.com.elo7.domain;

public class HeadingToEast implements Heading {

    @Override
    public void turnLeft(SpaceProbe spaceProbe) {
        spaceProbe.changeHeading(new HeadingToNorth());
    }

    @Override
    public void turnRight(SpaceProbe spaceProbe) {
        spaceProbe.changeHeading(new HeadingToSouth());
    }

    @Override
    public void move(Position position) {
        position.forwardCoordinateX();
    }

    @Override
    public CardinalDirection getCardinalDirection() {
        return CardinalDirection.EAST;
    }
}
