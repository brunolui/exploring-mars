package br.com.elo7.domain;

import static java.lang.String.format;

public enum CardinalDirection {

    NORTH("N", new HeadingToNorth()),
    SOUTH("S", new HeadingToSouth()),
    EAST("E", new HeadingToEast()),
    WEST("W", new HeadingToWest());

    private String direction;
    private Heading heading;

    CardinalDirection(String direction, Heading heading) {
        this.direction = direction;
        this.heading = heading;
    }

    public String getDirection() {
        return direction;
    }

    public Heading getHeading() {
        return heading;
    }

    public static CardinalDirection getBy(String direction) {
        for (CardinalDirection cardinalDirection : values()) {
            if (cardinalDirection.getDirection().equalsIgnoreCase(direction)) {
                return cardinalDirection;
            }
        }
        throw new IllegalArgumentException(format("Direction %s not found", direction));
    }
}
