package edu.sylymonka.theater.controller;/*
  @author   silim
  @project   theater
  @class  RoleController
  @version  1.0.0 
  @since 16.05.2024 - 22.36
*/

import edu.sylymonka.theater.dto.role.RoleDTO;
import edu.sylymonka.theater.dto.role.RoleInsertRequest;
import edu.sylymonka.theater.dto.role.RoleUpdateRequest;
import edu.sylymonka.theater.model.Role;
import edu.sylymonka.theater.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/role")
public class RoleController {
    private final RoleService service;
    public RoleController(RoleService service){
        this.service=service;
    }

    @GetMapping("/all")
    public List<RoleDTO> getAllRoles(){return service.getAllRoles();}

    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable long id){return service.getRoleById(id);}

    @PostMapping("/create")
    public RoleDTO createRole(@RequestBody RoleInsertRequest role){return service.createRole(role);}

    @PutMapping("/update")
    public RoleDTO updateRole(@RequestBody RoleUpdateRequest role){return service.updateRole(role);}

    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable long id){service.deleteRoleById(id);}


}
