package edu.sylymonka.theater.mapper;/*
  @author   silim
  @project   theater
  @class  RoleMapper
  @version  1.0.0 
  @since 28.05.2024 - 13.09
*/

import edu.sylymonka.theater.dto.role.RoleDTO;
import edu.sylymonka.theater.dto.role.RoleInsertRequest;
import edu.sylymonka.theater.dto.role.RoleUpdateRequest;
import edu.sylymonka.theater.model.Actor;
import edu.sylymonka.theater.model.Play;
import edu.sylymonka.theater.model.Role;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    private final ModelMapper mapper;

    public RoleMapper(ModelMapper mapper){
        this.mapper=mapper;
    }

    public RoleDTO toDTO(Role role){
        return mapper.map(role, RoleDTO.class);
    }
    public Role toRole(RoleInsertRequest request,Actor actor, Play play){
        return new Role(request.getName(),request.getType(),request.getAge(),request.getSex(),actor,play);
    }
    public Role toRole(RoleUpdateRequest request,Actor actor, Play play){
        return new Role(request.getId(),request.getName(),request.getType(),request.getAge(),request.getSex(),actor,play);

    }


}
