package br.com.elo7.web.resources;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.elo7.exception.FieldValidationException;

public class PlateauResource implements Serializable {

    @NotNull(message = "Plateau coordinates are required")
    private String coordinates;

    public PlateauResource() {
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public int getMaxX() {
        try {
            String[] positions = coordinates.split(" ");
            return Integer.parseInt(positions[0]);
        } catch (Exception e) {
            throw new FieldValidationException("Wrong coordinates format", "plateau coordinates");
        }
    }

    public int getMaxY() {
        try {
            String[] positions = coordinates.split(" ");
            return Integer.parseInt(positions[1]);
        } catch (Exception e) {
            throw new FieldValidationException("Wrong coordinates format", "plateau coordinates");
        }
    }

}
