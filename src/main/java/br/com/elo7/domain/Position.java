package br.com.elo7.domain;

import br.com.elo7.exception.BeyondLimitException;

import static java.lang.String.format;

class Position {

    private Plateau plateau;
    private int coordinateX;
    private int coordinateY;

    private Position(Plateau plateau, int coordinateX, int coordinateY) {
        this.plateau = plateau;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public static Position initialize(Plateau plateau, int coordinateX, int coordinateY) {
        return new Position(plateau, coordinateX, coordinateY);
    }

    public void forwardCoordinateY() {
        if (plateau.isBeyondMaxLimitYFor(coordinateY+1)) {
            throw new BeyondLimitException();
        }
        this.coordinateY++;
    }

    public void forwardCoordinateX() {
        if (plateau.isBeyondMaxLimitXFor(coordinateX+1)) {
            throw new BeyondLimitException();
        }
        this.coordinateX++;
    }

    public void backwardCoordinateY() {
        if (plateau.isBeyondMinLimitYFor(coordinateY-1)) {
            throw new BeyondLimitException();
        }
        this.coordinateY--;
    }

    public void backwardCoordinateX() {
        if (plateau.isBeyondMinLimitXFor(coordinateX-1)) {
            throw new BeyondLimitException();
        }
        this.coordinateX--;
    }

    @Override
    public String toString() {
        return format("%s %s", coordinateX, coordinateY);
    }
}
