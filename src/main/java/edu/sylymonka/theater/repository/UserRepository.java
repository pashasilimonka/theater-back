package edu.sylymonka.theater.repository;/*
  @author   silim
  @project   theater
  @class  UserRepository
  @version  1.0.0 
  @since 03.06.2024 - 17.47
*/

import edu.sylymonka.theater.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByLogin(String login);
}
