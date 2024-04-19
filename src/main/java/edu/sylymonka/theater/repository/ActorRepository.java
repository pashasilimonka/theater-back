package edu.sylymonka.theater.repository;/*
  @author   silim
  @project   theater
  @class  ActorRepository
  @version  1.0.0 
  @since 19.04.2024 - 12.51
*/

import edu.sylymonka.theater.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Long> {
}
