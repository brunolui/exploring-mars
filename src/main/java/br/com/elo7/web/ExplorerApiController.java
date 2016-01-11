package br.com.elo7.web;

import org.springframework.beans.factory.annotation.Autowired;
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
import br.com.elo7.service.ExplorerService;
import br.com.elo7.web.resources.InputWrapper;
import br.com.elo7.web.resources.PositionResource;
import br.com.elo7.web.resources.SpaceProbeResource;

@RestController
public class ExplorerApiController {

    @Autowired
    private ExplorerService explorerService;

    @RequestMapping(value = "/probes", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.CREATED)
    public List<PositionResource> create(@RequestBody @Valid InputWrapper inputWrapper) {
        return explorerService.explore(inputWrapper);
    }
}
