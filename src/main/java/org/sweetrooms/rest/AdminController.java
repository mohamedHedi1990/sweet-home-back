package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.AdminService;
import org.sweetrooms.persistence.entities.Admin;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
@Api(value = "Restfull APIs for admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @GetMapping("")
    public List<Admin> getAllAdmins()
    {
        return this.adminService.getAllAdmins();
    }
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable(name = "id") Long id)
    {
        return this.adminService.getAdminById(id);
    }
    @PostMapping("")
    public Admin saveAdmin(Admin admin)
    {
        return this.adminService.saveAdmin(admin);
    }
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable(name = "id")Long id)
    {
        this.adminService.deleteAdmin(id);
    }
}
