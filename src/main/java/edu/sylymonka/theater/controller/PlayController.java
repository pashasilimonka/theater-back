package edu.sylymonka.theater.controller;/*
  @author   silim
  @project   theater
  @class  PlayController
  @version  1.0.0 
  @since 19.04.2024 - 13.56
*/

import edu.sylymonka.theater.dto.play.PlayDTO;
import edu.sylymonka.theater.dto.play.PlayInsertRequest;
import edu.sylymonka.theater.dto.play.PlayUpdateRequest;
import edu.sylymonka.theater.service.PlayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@Tag(name = "Play controller",
        description = "Controller with endpoints for CRUD operations with play table")
@RequestMapping("api/v1/play")
public class PlayController {
    private final PlayService service;
    public PlayController(PlayService service){
        this.service=service;
    }
    @Operation(summary = "Get all records of play",
            description = "Returns a list which contains all records of play table")
    @GetMapping("/all")
    public List<PlayDTO> getAll(){
        return service.getAllPlays();
    }
    @Operation(summary = "Get 1 record of play by id",
            description = "Returns 1 record of play from table by id")
    @GetMapping("/{id}")
    public PlayDTO getById(@PathVariable long id){
        return service.getPlayById(id);
    }
    @Operation(summary = "Create new record in play table",
            description = "Returns a created record from play table")
    @PostMapping("/create")
    public PlayDTO addPlay(@RequestBody PlayInsertRequest play){
        return service.addPlay(play);
    }

    @Operation(summary = "Update 1 record from play table",
            description = "Returns an updated record from play table")
    @PutMapping("/update")
    public PlayDTO updatePlay(@RequestBody PlayUpdateRequest play){ return service.updatePlay(play);}

    @Operation(summary = "Delete 1 record from play table by id",
            description = "Deletes a record from play table by id if exists")
    @DeleteMapping("/delete/{id}")
    public void deletePlayById(@PathVariable long id){service.deletePlayById(id);}
}
