package edu.sylymonka.theater.mapper;/*
  @author   silim
  @project   theater
  @class  UserMapper
  @version  1.0.0 
  @since 24.05.2024 - 18.20
*/

import edu.sylymonka.theater.dto.play.PlayDTO;
import edu.sylymonka.theater.dto.play.PlayInsertRequest;
import edu.sylymonka.theater.dto.play.PlayUpdateRequest;
import edu.sylymonka.theater.model.Play;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PlayMapper {

    private final ModelMapper mapper;

    public PlayMapper(ModelMapper mapper){
        this.mapper=mapper;
    }

    public PlayDTO toDTO(Play play){
        return mapper.map(play, PlayDTO.class);
    }

    public Play toPlay(PlayInsertRequest request){
        return mapper.map(request, Play.class);
    }
    public Play toPlay(PlayUpdateRequest request){
        return mapper.map(request, Play.class);
    }


}
