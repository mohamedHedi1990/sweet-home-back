package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.AdminService;
import org.sweetrooms.persistence.entities.Admin;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
@Tag(description = "Restfull APIs for admin",name = "admin ressource")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Operation(summary = "Get admins",
            description = "Provides all available admins list")
    @GetMapping("")
    public List<Admin> getAllAdmins()
    {
        return this.adminService.getAllAdmins();
    }
    @Operation(summary = "Get admin",
            description = "Get specific admin By ID")
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable(name = "id") Long id)
    {
        return this.adminService.getAdminById(id);
    }
    @Operation(summary = "save admin",
            description = "save a new admin")
    @PostMapping("")
    public Admin saveAdmin(Admin admin)
    {
        return this.adminService.saveAdmin(admin);
    }
    @Operation(summary = "Delete admin",
            description = "Delete specific admin by ID")
    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable(name = "id")Long id)
    {
        this.adminService.deleteAdmin(id);
    }
}
