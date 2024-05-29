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
import edu.sylymonka.theater.service.SessionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Session controller",
        description = "Controller with endpoints for CRUD operations with sessions table")
@RequestMapping("api/v1/sessions")
public class SessionController {
    private final SessionService service;
    public SessionController(SessionService service){
        this.service=service;
    }
    @Operation(summary = "Get all records of sessions",
            description = "Returns a list which contains all records of sessions table")
    @GetMapping("/all")
    public List<SessionDTO> getAllSessions(){return service.getAllSessions();}
    @Operation(summary = "Get 1 record of session by id",
            description = "Returns 1 record of session from table by id")
    @GetMapping("/{id}")
    public SessionDTO getSessionById(@PathVariable long id){return service.getSessionById(id);}
    @Operation(summary = "Create new record in sessions table",
            description = "Returns a created record from sessions table")
    @PostMapping("/create")
    public SessionDTO createSession(@RequestBody SessionInsertRequest session){return service.createSession(session);}
    @Operation(summary = "Update 1 record from sessions table",
            description = "Returns an updated record from sessions table")
    @PutMapping("/update")
    public SessionDTO updateSession(@RequestBody SessionUpdateRequest session){return service.updateSession(session);}
    @Operation(summary = "Delete 1 record from sessions table by id",
            description = "Deletes a record from sessions table by id if exists")
    @DeleteMapping("/delete/{id}")
    public void deleteSessionById(@PathVariable long id){service.deleteSessionById(id);}
}
