package edu.sylymonka.theater.mapper;/*
  @author   silim
  @project   theater
  @class  ActorMapper
  @version  1.0.0 
  @since 24.05.2024 - 19.26
*/

import edu.sylymonka.theater.dto.actor.ActorDTO;
import edu.sylymonka.theater.dto.actor.ActorForRole;
import edu.sylymonka.theater.dto.actor.ActorInsertRequest;
import edu.sylymonka.theater.dto.actor.ActorUpdateRequest;
import edu.sylymonka.theater.model.Actor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ActorMapper {

    private final ModelMapper mapper;

    public ActorMapper(ModelMapper mapper){
        this.mapper=mapper;
    }

    public ActorDTO toDTO(Actor actor){
        return mapper.map(actor,ActorDTO.class);
    }

    public Actor toActor(ActorInsertRequest request){
        return mapper.map(request, Actor.class);
    }
    public void toActor(ActorUpdateRequest request, Actor actor){
         mapper.map(request, actor);
    }
    public ActorForRole toActorForRole(Actor actor){
        return mapper.map(actor,ActorForRole.class);
    }

}
