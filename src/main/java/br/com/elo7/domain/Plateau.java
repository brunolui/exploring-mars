package br.com.elo7.domain;

public class Plateau {

    private int minLimitX = 0;
    private int minLimitY = 0;
    private int maxLimitX;
    private int maxLimitY;

    public Plateau(int maxLimitX, int maxLimitY) {
        this.maxLimitX = maxLimitX;
        this.maxLimitY = maxLimitY;
    }

    public boolean isBeyondMaxLimitYFor(int coordinate) {
        return coordinate > maxLimitY;
    }

    public boolean isBeyondMaxLimitXFor(int coordinate) {
        return coordinate > maxLimitX;
    }

    public boolean isBeyondMinLimitYFor(int coordinate) {
        return coordinate < minLimitY;
    }

    public boolean isBeyondMinLimitXFor(int coordinate) {
        return coordinate < minLimitX;
    }
}
