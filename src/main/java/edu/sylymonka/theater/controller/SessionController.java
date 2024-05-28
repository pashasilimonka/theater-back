package edu.sylymonka.theater.controller;/*
  @author   silim
  @project   theater
  @class  SessionController
  @version  1.0.0 
  @since 16.05.2024 - 22.46
*/

import edu.sylymonka.theater.dto.session.SessionDTO;
import edu.sylymonka.theater.dto.session.SessionInsertRequest;
import edu.sylymonka.theater.dto.session.SessionUpdateRequest;
import edu.sylymonka.theater.model.Session;
import edu.sylymonka.theater.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/session")
public class SessionController {
    private final SessionService service;
    public SessionController(SessionService service){
        this.service=service;
    }

    @GetMapping("/all")
    public List<SessionDTO> getAllSessions(){return service.getAllSessions();}

    @GetMapping("/{id}")
    public SessionDTO getSessionById(@PathVariable long id){return service.getSessionById(id);}

    @PostMapping("/create")
    public SessionDTO createSession(@RequestBody SessionInsertRequest session){return service.createSession(session);}

    @PutMapping("/update")
    public SessionDTO updateSession(@RequestBody SessionUpdateRequest session){return service.updateSession(session);}

    @DeleteMapping("/delete/{id}")
    public void deleteSessionById(@PathVariable long id){service.deleteSessionById(id);}
}
