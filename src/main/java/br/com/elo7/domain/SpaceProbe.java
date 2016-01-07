package br.com.elo7.domain;

import static br.com.elo7.domain.CommandInstruction.getBy;
import static java.lang.String.format;

public class SpaceProbe {

    private Heading heading;
    private Position position;

    public SpaceProbe(Plateau plateau, int coordinateX, int coordinateY, String direction) {
        this.position = Position.initialize(plateau, coordinateX, coordinateY);
        this.heading = CardinalDirection.getBy(direction).getHeading();
    }

    public void run(String commands) {

        for (char command : commands.toCharArray()) {

            switch (getBy(command)) {
                case TURN_RIGHT:
                    heading.turnRight(this);
                    break;

                case TURN_LEFT:
                    heading.turnLeft(this);
                    break;

                case MOVE:
                    heading.move(this.position);
                    break;
            }
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
