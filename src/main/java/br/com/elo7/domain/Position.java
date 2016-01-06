package br.com.elo7.domain;

import static java.lang.String.format;

public class Position {

    private int coordinateX;
    private int coordinateY;

    private Position(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public static Position initialize(int coordinateX, int coordinateY) {
        return new Position(coordinateX, coordinateY);
    }

    public void forwardCoordinateY() {
        this.coordinateY++;
    }

    public void backwardCoordinateY() {
        this.coordinateY--;
    }

    public void forwardCoordinateX() {
        this.coordinateX++;
    }

    public void backwardCoordinateX() {
        this.coordinateX--;
    }

    @Override
    public String toString() {
        return format("%s %s", coordinateX, coordinateY);
    }
}
