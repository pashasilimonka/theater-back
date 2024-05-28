package edu.sylymonka.theater.service;/*
  @author   silim
  @project   theater
  @class  PlayRepository
  @version  1.0.0 
  @since 19.04.2024 - 13.54
*/

import edu.sylymonka.theater.dto.play.PlayDTO;
import edu.sylymonka.theater.dto.play.PlayInsertRequest;
import edu.sylymonka.theater.dto.play.PlayUpdateRequest;
import edu.sylymonka.theater.mapper.PlayMapper;
import edu.sylymonka.theater.model.Play;
import edu.sylymonka.theater.repository.PlayRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayService {
    private final PlayRepository repository;
    private final PlayMapper mapper;
    public PlayService(PlayRepository repository, PlayMapper mapper){
        this.repository=repository;
        this.mapper = mapper;
    }
    public List<PlayDTO> getAllPlays(){
        List<Play> result = repository.findAll();
        return result.stream().map(mapper::toDTO).collect(Collectors.toList());
    }
    public PlayDTO getPlayById(long id){
        Play result = repository.getReferenceById(id);
        return mapper.toDTO(result);
    }
    public PlayDTO addPlay(PlayInsertRequest request){
        Play toInsert  = mapper.toPlay(request);
        return mapper.toDTO(repository.save(toInsert));
    }
    public void deletePlayById(long id){
        repository.deleteById(id);
    }
    public PlayDTO updatePlay(PlayUpdateRequest play){
        Play toUpdate = mapper.toPlay(play);
        return mapper.toDTO(repository.save(toUpdate));
    }
}
