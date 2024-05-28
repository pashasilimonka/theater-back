package edu.sylymonka.theater.service;/*
  @author   silim
  @project   theater
  @class  ActorService
  @version  1.0.0 
  @since 21.04.2024 - 19.50
*/

import edu.sylymonka.theater.dto.actor.ActorDTO;
import edu.sylymonka.theater.dto.actor.ActorInsertRequest;
import edu.sylymonka.theater.dto.actor.ActorUpdateRequest;
import edu.sylymonka.theater.mapper.ActorMapper;
import edu.sylymonka.theater.model.Actor;
import edu.sylymonka.theater.model.Play;
import edu.sylymonka.theater.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorService {
    private final ActorRepository repository;
    private final ActorMapper mapper;
    public ActorService(ActorRepository repository,
                        ActorMapper mapper){
        this.repository=repository;
        this.mapper=mapper;
    }
    public List<ActorDTO> getAllActors(){
        List<Actor> result = repository.findAll();
        return result.stream().map(mapper::toDTO).collect(Collectors.toList());
    }
    public ActorDTO getActorById(long id){
        Actor result = repository.getReferenceById(id);
        return mapper.toDTO(result);
    }
    public ActorDTO createActor(ActorInsertRequest request){
        Actor actor = mapper.toActor(request);
        return mapper.toDTO(repository.save(actor));
    }
    public void deletePlayById(long id){
        repository.deleteById(id);
    }
    public ActorDTO updateActor(ActorUpdateRequest request){
        Actor actor = mapper.toActor(request);
        return mapper.toDTO(repository.save(actor));
    }
}
