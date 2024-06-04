package edu.sylymonka.theater.controller;/*
  @author   silim
  @project   theater
  @class  ActorController
  @version  1.0.0 
  @since 21.04.2024 - 19.53
*/

import edu.sylymonka.theater.dto.actor.ActorDTO;
import edu.sylymonka.theater.dto.actor.ActorForRole;
import edu.sylymonka.theater.dto.actor.ActorInsertRequest;
import edu.sylymonka.theater.dto.actor.ActorUpdateRequest;
import edu.sylymonka.theater.service.ActorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actors")
@Tag(name = "Actor controller",
description = "Controller with endpoints for CRUD operations with actors table")
public class ActorController {

    private final ActorService actorService;
    public ActorController(ActorService actorService){
        this.actorService=actorService;
    }
    @Operation(summary = "Get all records of actors",
            description = "Returns a list which contains all records of actors table")
    @GetMapping("/all")
    public ResponseEntity<List<ActorDTO>> getAllActors(){
        try {

            List<ActorDTO> result = actorService.getAllActors();
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        }
    @Operation(summary = "Get all records of actors",
    description = "Returns a list of all actors for actors list page")
    @GetMapping("/all-list")
    public ResponseEntity<List<ActorForRole>> getAllActorsList(){
        try {
            List<ActorForRole> result = actorService.getAllActorsForList();
            return ResponseEntity.ok(result);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Get 1 record of actor by id",
            description = "Returns 1 record from actors table by id")
    @GetMapping("/{id}")
    public ResponseEntity<ActorDTO> getActorById(@PathVariable long id){
            ActorDTO result = actorService.getActorById(id);
            return ResponseEntity.ok(result);
    }

    @Operation(summary = "Create a new record of actor",
            description = "Returns created record from actors table")
    @PostMapping("/create")
    public ActorDTO createActor(@RequestBody ActorInsertRequest actor){return actorService.createActor(actor);}

    @Operation(summary = "Update 1 record of actor",
            description = "Returns an updated record from actors table")
    @PutMapping("/update")
    public ActorDTO updateActor(@RequestBody ActorUpdateRequest actor){return actorService.updateActor(actor);}

    @Operation(summary = "Delete record of actor by id",
            description = "Deletes 1 record from actors table by id if exists")
    @DeleteMapping("/delete/{id}")
    public void deleteActorById(@PathVariable long id){actorService.deletePlayById(id);}
}
