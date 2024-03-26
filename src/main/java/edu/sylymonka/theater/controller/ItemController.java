package edu.sylymonka.theater.controller;/*
  @author   silim
  @project   theater
  @class  ItemController
  @version  1.0.0 
  @since 26.03.2024 - 13.55
*/

import edu.sylymonka.theater.model.Item;
import edu.sylymonka.theater.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/items/")
public class ItemController {
    @Autowired
    private ItemRepository repository;

    @PostMapping("")
    public Item create(@RequestBody Item item){
        return  repository.save(item);
    }@GetMapping("")
    public Iterable<Item> getAll(){
        return  repository.findAll();
    }

}
