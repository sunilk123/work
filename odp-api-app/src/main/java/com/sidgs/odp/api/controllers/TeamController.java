package com.sidgs.odp.api.controllers;

import com.sidgs.odp.model.Team;
import com.sidgs.odp.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ayeluri on 6/3/2017.
 */
@RestController
@RequestMapping (path = "team")
public class TeamController {

    @Autowired
    TeamRepository teamRepository ;

    @ResponseStatus (HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create( @RequestBody Team team) {
        teamRepository.save(team);
    }


    @ResponseStatus (HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Team> list() {
        return  teamRepository.findAll();
    }


    @ResponseStatus (HttpStatus.OK)
    @RequestMapping(method = RequestMethod.GET, path = "/{type}/{id}/{value}",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update (@PathVariable("type") String type , @PathVariable("id")String id, @PathVariable("value") String value) {
        teamRepository.findAll();
    }


}
