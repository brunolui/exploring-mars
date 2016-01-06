package br.com.elo7.domain;

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

}
