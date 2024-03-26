package edu.sylymonka.theater.repository;/*
  @author   silim
  @project   theater
  @class  ItemRepository
  @version  1.0.0 
  @since 26.03.2024 - 13.53
*/

import edu.sylymonka.theater.model.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item,Long> {
}
