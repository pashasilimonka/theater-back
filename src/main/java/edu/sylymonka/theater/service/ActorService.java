package edu.sylymonka.theater.service;/*
  @author   silim
  @project   theater
  @class  ActorService
  @version  1.0.0 
  @since 21.04.2024 - 19.50
*/

import edu.sylymonka.theater.dto.actor.ActorDTO;
import edu.sylymonka.theater.dto.actor.ActorForRole;
import edu.sylymonka.theater.dto.actor.ActorInsertRequest;
import edu.sylymonka.theater.dto.actor.ActorUpdateRequest;
import edu.sylymonka.theater.mapper.ActorMapper;
import edu.sylymonka.theater.model.Actor;
import edu.sylymonka.theater.repository.ActorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static edu.sylymonka.theater.utils.ActorUtils.validateInsertRequest;
import static edu.sylymonka.theater.utils.ActorUtils.validateUpdateRequest;

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
        if (result.isEmpty()){
            throw new EntityNotFoundException("No actors found");
        }
        return result.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public List<ActorForRole> getAllActorsForList(){
        List<Actor> result = repository.findAll();
        if (result.isEmpty()){
            throw new EntityNotFoundException("No actors found");
        }
        return result.stream().map(mapper::toActorForRole).toList();
    }
    public ActorDTO getActorById(long id){
        Optional<Actor> actorOpt = repository.findById(id);
        if (actorOpt.isPresent()) {
            return mapper.toDTO(actorOpt.get());
        } else {
            throw new EntityNotFoundException("Actor with id " + id + " not found");
        }
    }
    public ActorDTO createActor(ActorInsertRequest request){
        validateInsertRequest(request);
        Actor actor = mapper.toActor(request);
        return mapper.toDTO(repository.save(actor));
    }
    public void deletePlayById(long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("Actor with id "+id+" not found");
        }
        repository.deleteById(id);
    }

    public ActorDTO updateActor(ActorUpdateRequest request){
        if(!repository.existsById(request.getId())){
            throw new IllegalStateException("Actor with id "+request.getId()+" does not exist");
        }
        validateUpdateRequest(request);
        Actor toUpdate = repository.getReferenceById(request.getId());
        mapper.toActor(request, toUpdate);
        return mapper.toDTO(repository.save(toUpdate));
    }
}
