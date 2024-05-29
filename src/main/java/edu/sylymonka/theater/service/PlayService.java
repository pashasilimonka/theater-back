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
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static edu.sylymonka.theater.utils.PlayUtils.validateInsertRequest;
import static edu.sylymonka.theater.utils.PlayUtils.validateUpdateRequest;

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
        if(result.isEmpty()){
            throw new EntityNotFoundException("No plays found");
        }
        return result.stream().map(mapper::toDTO).collect(Collectors.toList());
    }
    public PlayDTO getPlayById(long id){
       Optional<Play> result = repository.findById(id);
        if (result.isPresent()){
            return mapper.toDTO(result.get());
        }else {
            throw new EntityNotFoundException("No play with id "+id+" found");
        }

    }
    public PlayDTO addPlay(PlayInsertRequest request){
        validateInsertRequest(request);
        Play toInsert  = mapper.toPlay(request);
        return mapper.toDTO(repository.save(toInsert));
    }
    public void deletePlayById(long id){
        if (!repository.existsById(id)){
            throw new EntityNotFoundException("No play with id "+id+" found");
        }
        repository.deleteById(id);
    }
    public PlayDTO updatePlay(PlayUpdateRequest play){
        if (!repository.existsById(play.getId())){
            throw new EntityNotFoundException("No play with id "+play.getId()+" found");
        }
        validateUpdateRequest(play);
        Play toUpdate = mapper.toPlay(play);
        return mapper.toDTO(repository.save(toUpdate));
    }
}
