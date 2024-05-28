package edu.sylymonka.theater.service;/*
  @author   silim
  @project   theater
  @class  RoleService
  @version  1.0.0 
  @since 16.05.2024 - 22.32
*/

import edu.sylymonka.theater.dto.role.RoleDTO;
import edu.sylymonka.theater.dto.role.RoleInsertRequest;
import edu.sylymonka.theater.dto.role.RoleUpdateRequest;
import edu.sylymonka.theater.mapper.RoleMapper;
import edu.sylymonka.theater.model.Actor;
import edu.sylymonka.theater.model.Play;
import edu.sylymonka.theater.model.Role;
import edu.sylymonka.theater.repository.ActorRepository;
import edu.sylymonka.theater.repository.PlayRepository;
import edu.sylymonka.theater.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleService {
    private final RoleRepository repository;
    private final ActorRepository actorRepository;
    private final PlayRepository playRepository;
    private final RoleMapper mapper;
    public  RoleService(
            RoleRepository repository,
            ActorRepository actorRepository,
            PlayRepository playRepository,
            RoleMapper mapper
    ){
        this.repository=repository;
        this.mapper = mapper;
        this.actorRepository=actorRepository;
        this.playRepository=playRepository;
    }

    public List<RoleDTO> getAllRoles(){
        List<Role> result = repository.findAll();
        return result.stream().map(mapper::toDTO).toList();
    }
    public RoleDTO getRoleById(long id){
        Role result = repository.getReferenceById(id);
        return mapper.toDTO(result);
    }
    public RoleDTO createRole(RoleInsertRequest request){
        Actor actor = actorRepository.getReferenceById(request.getActor_id());
        Play play = playRepository.getReferenceById(request.getPlay_id());
        Role role = mapper.toRole(request,actor,play);
        return mapper.toDTO(repository.save(role));
    }
    public void deleteRoleById(long id){
        repository.deleteById(id);
    }
    public RoleDTO updateRole(RoleUpdateRequest request){
        Actor actor = actorRepository.getReferenceById(request.getActor_id());
        Play play = playRepository.getReferenceById(request.getPlay_id());
        Role role = mapper.toRole(request,actor,play);
        return mapper.toDTO(repository.save(role));
    }
}
