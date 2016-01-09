package br.com.elo7.web.resources;

import java.io.Serializable;

public class PositionResource implements Serializable {

    private String position;

    public PositionResource(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }
}
