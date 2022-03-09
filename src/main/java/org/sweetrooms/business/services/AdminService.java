package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Admin;
import org.sweetrooms.persistence.repositories.AdminRepository;

import java.util.List;

@Service
public class AdminService {


    @Autowired
    AdminRepository adminRepository;

    public List<Admin> getAllAdmins()
    {
        return this.adminRepository.findAll();

    }

    public Admin getAdminById(Long id)
    {
        return this.adminRepository.getById(id);
    }
    public Admin saveAdmin(Admin admin)
    {
        return this.adminRepository.save(admin);
    }
    public void deleteAdmin(Long id)
    {
        this.adminRepository.deleteById(id);
    }
}
