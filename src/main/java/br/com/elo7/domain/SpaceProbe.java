package br.com.elo7.domain;

import java.util.List;

import static br.com.elo7.domain.CommandInstruction.convert;
import static java.lang.String.format;

public class SpaceProbe {

    private Heading heading;
    private Position position;
    private List<Command> commands;

    public SpaceProbe(Plateau plateau, int coordinateX, int coordinateY, String direction, String instructions) {
        this.position = Position.initialize(plateau, coordinateX, coordinateY);
        this.heading = CardinalDirection.getBy(direction).getHeading();
        this.commands = convert(instructions);
    }

    public void run() {
        for (Command command : this.commands) {
            command.run(this);
        }
    }

    public CardinalDirection getCardinalDirection() {
        return this.heading.getCardinalDirection();
    }

    void changeHeading(Heading newHeading) {
        this.heading = newHeading;
    }

    void turnRight() {
        heading.turnRight(this);
    }

    void turnLeft() {
        heading.turnLeft(this);
    }

    void move() {
        heading.move(this.position);
    }

    @Override
    public String toString() {
        return format("%s %s", position, heading.getCardinalDirection().getDirection());
    }
}
