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
import edu.sylymonka.theater.model.Play;
import edu.sylymonka.theater.service.PlayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/play")
public class PlayController {
    private final PlayService service;
    public PlayController(PlayService service){
        this.service=service;
    }
    @GetMapping("/all")
    public List<PlayDTO> getAll(){
        return service.getAllPlays();
    }
    @GetMapping("/{id}")
    public PlayDTO getById(@PathVariable long id){
        return service.getPlayById(id);
    }
    @PostMapping("/create")
    public PlayDTO addPlay(@RequestBody PlayInsertRequest play){
        return service.addPlay(play);
    }

    @PutMapping("/update")
    public PlayDTO updatePlay(@RequestBody PlayUpdateRequest play){ return service.updatePlay(play);}

    @DeleteMapping("/delete/{id}")
    public void deletePlayById(@PathVariable long id){service.deletePlayById(id);}
}
