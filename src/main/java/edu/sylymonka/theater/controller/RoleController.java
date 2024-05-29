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
import edu.sylymonka.theater.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Role controller",
        description = "Controller with endpoints for CRUD operations with roles table")
@RequestMapping("api/v1/roles")
public class RoleController {
    private final RoleService service;
    public RoleController(RoleService service){
        this.service=service;
    }
    @Operation(summary = "Get all records of roles",
            description = "Returns a list which contains all records of roles table")
    @GetMapping("/all")
    public List<RoleDTO> getAllRoles(){return service.getAllRoles();}
    @Operation(summary = "Get 1 record of role by id",
            description = "Returns 1 record of role from table by id")
    @GetMapping("/{id}")
    public RoleDTO getRoleById(@PathVariable long id){return service.getRoleById(id);}
    @Operation(summary = "Create new record in roles table",
            description = "Returns a created record from roles table")
    @PostMapping("/create")
    public RoleDTO createRole(@RequestBody RoleInsertRequest role){return service.createRole(role);}
    @Operation(summary = "Update 1 record from roles table",
            description = "Returns an updated record from roles table")
    @PutMapping("/update")
    public RoleDTO updateRole(@RequestBody RoleUpdateRequest role){return service.updateRole(role);}
    @Operation(summary = "Delete 1 record from roles table by id",
            description = "Deletes a record from roles table by id if exists")
    @DeleteMapping("/delete/{id}")
    public void deleteRole(@PathVariable long id){service.deleteRoleById(id);}


}
