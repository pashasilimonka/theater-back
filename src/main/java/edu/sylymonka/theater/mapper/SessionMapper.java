package edu.sylymonka.theater.mapper;/*
  @author   silim
  @project   theater
  @class  SessionMapper
  @version  1.0.0 
  @since 28.05.2024 - 14.48
*/


import edu.sylymonka.theater.dto.session.SessionDTO;
import edu.sylymonka.theater.dto.session.SessionInsertRequest;
import edu.sylymonka.theater.dto.session.SessionUpdateRequest;
import edu.sylymonka.theater.model.Play;
import edu.sylymonka.theater.model.Session;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class SessionMapper {
    private final ModelMapper mapper;

    public SessionMapper(ModelMapper mapper){
        this.mapper=mapper;
    }

    public SessionDTO toDTO(Session session){
        return mapper.map(session,SessionDTO.class);
    }
    public Session toSession(SessionInsertRequest request, Play play){
        return new Session(request.getDateOfSession(),request.getTimeOfSession(),play);
    }
    public Session toSession(SessionUpdateRequest request, Play play){
        return new Session(request.getDateOfSession(),request.getTimeOfSession(),play);
    }
}
