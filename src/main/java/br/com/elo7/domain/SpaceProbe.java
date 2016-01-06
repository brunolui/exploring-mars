package br.com.elo7.domain;

import static java.lang.String.*;

public class SpaceProbe {

    private Heading heading;
    private Position position;

    public SpaceProbe(int coordinateX, int coordinateY, String direction) {
        this.position = Position.initialize(coordinateX, coordinateY);
        this.heading = CardinalDirection.getBy(direction).getHeading();
    }

    public void run(String command) {
        if (command.equals("R")) {
            heading.turnRight(this);

        } else if (command.equals("L")) {
            heading.turnLeft(this);

        } else if (command.equals("M")) {
            heading.move(this.position);
        }
    }

    public void changeHeading(Heading newHeading) {
        this.heading = newHeading;
    }

    public CardinalDirection getCardinalDirection() {
        return this.heading.getCardinalDirection();
    }

    @Override
    public String toString() {
        return format("%s %s", position, heading.getCardinalDirection().getDirection());
    }
}
