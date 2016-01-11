package br.com.elo7.service;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.elo7.domain.Plateau;
import br.com.elo7.domain.SpaceProbe;
import br.com.elo7.web.resources.InputWrapper;
import br.com.elo7.web.resources.PositionResource;
import br.com.elo7.web.resources.SpaceProbeResource;

@Service
public class ExplorerService {

    public List<PositionResource> explore(InputWrapper inputWrapper) {

        Plateau plateau = new Plateau(inputWrapper.getPlateauMaxX(), inputWrapper.getPlateauMaxY());

        List<PositionResource> positions = new LinkedList<>();

        for (SpaceProbeResource spaceProbeResource : inputWrapper.getSpaceProbes()) {

            SpaceProbe spaceProbe = new SpaceProbe(plateau,
                                                   spaceProbeResource.getCoordinateX(),
                                                   spaceProbeResource.getCoordinateY(),
                                                   spaceProbeResource.getDirection(),
                                                   spaceProbeResource.getInstructions());
            spaceProbe.run();

            positions.add(new PositionResource(spaceProbe.toString()));
        }


        return positions;
    }
}
