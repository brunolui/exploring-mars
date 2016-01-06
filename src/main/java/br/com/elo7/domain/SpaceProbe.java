package br.com.elo7.domain;

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
        }
    }

    public void changeHeading(Heading newHeading) {
        this.heading = newHeading;
    }

    public CardinalDirection getCardinalDirection() {
        return this.heading.getDirection();
    }

}
