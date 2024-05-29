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
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static edu.sylymonka.theater.utils.RoleUtils.validateInsertRequest;
import static edu.sylymonka.theater.utils.RoleUtils.validateUpdateRequest;


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
        if(result.isEmpty()){
            throw new EntityNotFoundException("No roles found");
        }
        return result.stream().map(mapper::toDTO).toList();
    }
    public RoleDTO getRoleById(long id){
        Optional<Role> result = repository.findById(id);
        if (result.isPresent()){
            return mapper.toDTO(result.get());
        }else {
            throw new EntityNotFoundException("No role with id "+id+" found");
        }

    }
    public RoleDTO createRole(RoleInsertRequest request){
        validateInsertRequest(request);
        Actor actor = actorRepository.findById(request.getActor_id()).orElseThrow(EntityNotFoundException::new);
        Play play = playRepository.findById(request.getPlay_id()).orElseThrow(EntityNotFoundException::new);
        Role role = mapper.toRole(request,actor,play);
        return mapper.toDTO(repository.save(role));
    }
    public void deleteRoleById(long id){
        repository.deleteById(id);
    }
    public RoleDTO updateRole(RoleUpdateRequest request){
        validateUpdateRequest(request);
        if (!repository.existsById(request.getId())){
            throw new EntityNotFoundException("No role with id "+request.getId()+" found");
        }
        Actor actor = actorRepository.findById(request.getActor_id()).orElseThrow(EntityNotFoundException::new);
        Play play = playRepository.findById(request.getPlay_id()).orElseThrow(EntityNotFoundException::new);
        Role role = mapper.toRole(request,actor,play);
        return mapper.toDTO(repository.save(role));
    }
}
