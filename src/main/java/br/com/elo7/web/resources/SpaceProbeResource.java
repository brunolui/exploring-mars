package br.com.elo7.web.resources;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.elo7.exception.FieldValidationException;

public class SpaceProbeResource implements Serializable {

    @NotNull(message = "Space probe coordinates are required")
    private String coordinates;

    @NotNull(message = "Space probe direction is required")
    private String direction;

    @NotNull(message = "Instructions are required")
    private String instructions;

    public SpaceProbeResource() {
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDirection() {
        return direction;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getCoordinateX() {
        try {
            String[] positions = coordinates.split(" ");
            return Integer.parseInt(positions[0]);
        } catch (Exception e) {
            throw new FieldValidationException("Wrong coordinates format", "space probe coordinates");
        }
    }

    public int getCoordinateY() {
        try {
            String[] positions = coordinates.split(" ");
            return Integer.parseInt(positions[1]);
        } catch (Exception e) {
            throw new FieldValidationException("Wrong coordinates format", "space probe coordinates");
        }
    }
}
