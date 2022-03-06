package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.RoleService;
import org.sweetrooms.persistence.entities.Role;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/role")
@Api(value = "Restfull APIs for role")
public class RoleController {
    @Autowired
    RoleService roleService;
    @GetMapping("")
    public List<Role> getAllRoles()
    {
        return this.roleService.getAllRoles();
    }
    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable(name = "id") Long id)
    {
        return this.roleService.getRoleById(id);
    }
    @PostMapping("")
    public Role saveRole(Role role)
    {
        return this.roleService.saveRole(role);
    }
    @DeleteMapping("/{id}")
    public void deleteRole(@PathVariable(name = "id")Long id)
    {
        this.roleService.deleteRole(id);
    }
}
