package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Role;
import org.sweetrooms.persistence.repositories.RoleRepository;


import java.util.List;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public List<Role> getAllRoles()
    {
        return this.roleRepository.findAll();
    }

    public Role getRoleById(Long id)
    {
        return this.roleRepository.getById(id);
    }
    public Role saveRole(Role role)
    {
        return this.roleRepository.save(role);
    }
    public void deleteRole(Long id)
    {
        this.roleRepository.deleteById(id);
    }
}
