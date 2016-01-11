package br.com.elo7.domain;

import java.io.Serializable;

public interface Heading extends Serializable {

    void turnLeft(SpaceProbe spaceProbe);

    void turnRight(SpaceProbe spaceProbe);

    void move(Position position);

    CardinalDirection getCardinalDirection();

}
