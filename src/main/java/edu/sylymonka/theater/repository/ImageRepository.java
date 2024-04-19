package edu.sylymonka.theater.repository;/*
  @author   silim
  @project   theater
  @class  ImageRepository
  @version  1.0.0 
  @since 19.04.2024 - 12.53
*/

import edu.sylymonka.theater.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
