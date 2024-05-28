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
import edu.sylymonka.theater.model.Role;
import edu.sylymonka.theater.model.Session;
import edu.sylymonka.theater.repository.PlayRepository;
import edu.sylymonka.theater.repository.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return result.stream().map(mapper::toDTO).toList();
    }
    public SessionDTO getSessionById(long id){
        Session result = repository.getReferenceById(id);
        return mapper.toDTO(result);
    }
    public SessionDTO createSession(SessionInsertRequest request){
        Play play = playRepository.getReferenceById(request.getPlay_id());
        Session session = mapper.toSession(request,play);
        return mapper.toDTO(repository.save(session));
    }

    public void deleteSessionById(long id){
        repository.deleteById(id);
    }
    public SessionDTO updateSession(SessionUpdateRequest request){
        Play play = playRepository.getReferenceById(request.getPlay_id());
        Session session = mapper.toSession(request,play);
        return mapper.toDTO(repository.save(session));
    }
}
