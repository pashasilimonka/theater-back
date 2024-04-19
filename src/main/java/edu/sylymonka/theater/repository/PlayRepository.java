package edu.sylymonka.theater.repository;/*
  @author   silim
  @project   theater
  @class  PlayRepository
  @version  1.0.0 
  @since 26.03.2024 - 14.24
*/

import edu.sylymonka.theater.model.Play;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayRepository extends JpaRepository<Play,Long> {
}
