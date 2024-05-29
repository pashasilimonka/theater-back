package edu.sylymonka.theater.service;/*
  @author   silim
  @project   theater
  @class  SessionService
  @version  1.0.0 
  @since 16.05.2024 - 22.42
*/

import edu.sylymonka.theater.dto.session.SessionDTO;
import edu.sylymonka.theater.dto.session.SessionInsertRequest;
import edu.sylymonka.theater.dto.session.SessionUpdateRequest;
import edu.sylymonka.theater.mapper.SessionMapper;
import edu.sylymonka.theater.model.Play;
import edu.sylymonka.theater.model.Session;
import edu.sylymonka.theater.repository.PlayRepository;
import edu.sylymonka.theater.repository.SessionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static edu.sylymonka.theater.utils.SessionUtils.validateInsertRequest;
import static edu.sylymonka.theater.utils.SessionUtils.validateUpdateRequest;

@Service
public class SessionService {
    private final SessionRepository repository;
    private final PlayRepository playRepository;
    private final SessionMapper mapper;
    public SessionService(
            SessionRepository repository,
            PlayRepository playRepository,
            SessionMapper mapper){
        this.repository=repository;
        this.playRepository=playRepository;
        this.mapper=mapper;
    }

    public List<SessionDTO> getAllSessions(){
        List<Session> result = repository.findAll();
        if (result.isEmpty()){
            throw new EntityNotFoundException("No sessions found");
        }
        return result.stream().map(mapper::toDTO).toList();
    }
    public SessionDTO getSessionById(long id){
       Optional<Session> result = repository.findById(id);
        if(result.isPresent()){
            return mapper.toDTO(result.get());
        }else {
            throw new EntityNotFoundException("No session with id "+id+" found");
        }
    }
    public SessionDTO createSession(SessionInsertRequest request){
        validateInsertRequest(request);
        Play play = playRepository.findById(request.getPlay_id()).orElseThrow(EntityNotFoundException::new);
        Session session = mapper.toSession(request,play);
        return mapper.toDTO(repository.save(session));
    }

    public void deleteSessionById(long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("No session with id "+id+" found");
        }
        repository.deleteById(id);
    }
    public SessionDTO updateSession(SessionUpdateRequest request){
        if (!repository.existsById(request.getId())){
            throw new EntityNotFoundException("No session with id "+request.getId()+" found");
        }
        validateUpdateRequest(request);
        Play play = playRepository.findById(request.getPlay_id()).orElseThrow(EntityNotFoundException::new);
        Session session = mapper.toSession(request,play);
        return mapper.toDTO(repository.save(session));
    }
}
