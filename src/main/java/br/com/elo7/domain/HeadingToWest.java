package br.com.elo7.domain;

public class HeadingToWest implements Heading {

    @Override
    public void turnLeft(SpaceProbe spaceProbe) {
        spaceProbe.changeHeading(new HeadingToSouth());
    }

    @Override
    public void turnRight(SpaceProbe spaceProbe) {
        spaceProbe.changeHeading(new HeadingToNorth());
    }

    @Override
    public void move(Position position) {
        position.backwardCoordinateX();
    }

    @Override
    public CardinalDirection getCardinalDirection() {
        return CardinalDirection.WEST;
    }
}
