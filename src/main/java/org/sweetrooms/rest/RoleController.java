package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.RoleService;
import org.sweetrooms.persistence.entities.Role;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/role")
@Tag(description = "Restfull APIs for role",name = "role ressource")
public class RoleController {
    @Autowired
    RoleService roleService;
    @Operation(summary = "Get roles",
            description = "Provides all available roles list")
    @GetMapping("")
    public List<Role> getAllRoles()
    {
        return this.roleService.getAllRoles();
    }
    @Operation(summary = "Get role by ID",
            description = "Provides role by specific ID")
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable(name = "id") Long id)
    {
        return this.roleService.getRoleById(id);
    }
    @Operation(summary = "save role",
            description = "Save role ")
    @PostMapping("")
    public Role saveRole(Role role)
    {
        return this.roleService.saveRole(role);
    }
    @Operation(summary = "Delete role",
            description = "Delete role by specific ID")
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable(name = "id")Long id)
    {
        this.roleService.deleteRole(id);
    }
}
