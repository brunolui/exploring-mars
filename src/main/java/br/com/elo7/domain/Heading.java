package br.com.elo7.domain;

public interface Heading {

    void turnLeft(SpaceProbe spaceProbe);

    void turnRight(SpaceProbe spaceProbe);

    void move(Position position);

    CardinalDirection getCardinalDirection();

}
