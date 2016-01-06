package br.com.elo7.domain;

public class HeadingToNorth implements Heading {

    @Override
    public void turnLeft(SpaceProbe spaceProbe) {
        spaceProbe.changeHeading(new HeadingToWest());
    }

    @Override
    public void turnRight(SpaceProbe spaceProbe) {
        spaceProbe.changeHeading(new HeadingToEast());
    }

    @Override
    public void move(Position position) {
        position.forwardCoordinateY();
    }

    @Override
    public CardinalDirection getCardinalDirection() {
        return CardinalDirection.NORTH;
    }
}
