package br.com.elo7.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

import javax.validation.Valid;

import br.com.elo7.domain.Plateau;
import br.com.elo7.domain.SpaceProbe;
import br.com.elo7.web.resources.InputWrapper;
import br.com.elo7.web.resources.PositionResource;
import br.com.elo7.web.resources.SpaceProbeResource;

@RestController
public class ExplorerApiController {

    @RequestMapping(value = "/probes", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public List<PositionResource> create(@RequestBody @Valid InputWrapper inputWrapper) {

        Plateau plateau = new Plateau(inputWrapper.getPlateauMaxX(), inputWrapper.getPlateauMaxY());

        List<PositionResource> positions = new LinkedList<>();

        for (SpaceProbeResource spaceProbeResource : inputWrapper.getSpaceProbes()) {

            SpaceProbe spaceProbe = new SpaceProbe(plateau,
                                                   spaceProbeResource.getCoordinateX(),
                                                   spaceProbeResource.getCoordinateY(),
                                                   spaceProbeResource.getDirection());

            spaceProbe.run(spaceProbeResource.getInstructions());

            positions.add(new PositionResource(spaceProbe.toString()));
        }

        return positions;
    }
}
