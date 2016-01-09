package br.com.elo7.web.resources;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.elo7.web.resources.PlateauResource;
import br.com.elo7.web.resources.SpaceProbeResource;

public class InputWrapper implements Serializable {

    @NotNull(message = "Plateau are required")
    private @Valid PlateauResource plateau;

    @NotEmpty(message = "At least one space probe is required")
    private @Valid List<SpaceProbeResource> spaceProbes;

    public InputWrapper() {
    }

    public void setPlateau(PlateauResource plateau) {
        this.plateau = plateau;
    }

    public void setSpaceProbes(List<SpaceProbeResource> spaceProbes) {
        this.spaceProbes = spaceProbes;
    }

    public PlateauResource getPlateau() {
        return plateau;
    }

    public List<SpaceProbeResource> getSpaceProbes() {
        return spaceProbes;
    }

    public int getPlateauMaxX() {
        return plateau.getMaxX();
    }

    public int getPlateauMaxY() {
        return plateau.getMaxY();
    }
}
