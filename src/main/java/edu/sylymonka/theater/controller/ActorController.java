package edu.sylymonka.theater.controller;/*
  @author   silim
  @project   theater
  @class  ActorController
  @version  1.0.0 
  @since 21.04.2024 - 19.53
*/

import edu.sylymonka.theater.dto.actor.ActorDTO;
import edu.sylymonka.theater.dto.actor.ActorInsertRequest;
import edu.sylymonka.theater.dto.actor.ActorUpdateRequest;
import edu.sylymonka.theater.model.Actor;
import edu.sylymonka.theater.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actors/")
public class ActorController {

    private final ActorService actorService;
    public ActorController(ActorService actorService){
        this.actorService=actorService;
    }
    @GetMapping("/all")
    public List<ActorDTO> getAllActors(){return actorService.getAllActors();}

    @GetMapping("/{id}")
    public ActorDTO getActorById(@PathVariable long id){return actorService.getActorById(id);}

    @PostMapping("/create")
    public ActorDTO createActor(@RequestBody ActorInsertRequest actor){return actorService.createActor(actor);}

    @PutMapping("/update")
    public ActorDTO updateActor(@RequestBody ActorUpdateRequest actor){return actorService.updateActor(actor);}

    @DeleteMapping("/delete/{id}")
    public void deleteActorById(@PathVariable long id){actorService.deletePlayById(id);}
}
