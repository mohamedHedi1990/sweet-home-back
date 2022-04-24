package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.UserService;
import org.sweetrooms.client.dtos.request.UserRequest;
import org.sweetrooms.persistence.entities.User;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Tag(description = "Restfull APIs for user",name = "user ressource")
public class UserController {

    @Autowired
    UserService userService;
    @Operation(summary = "Get users",
            description = "Provides all available users list")
    @GetMapping("")
    public List<User> getAllUsers()
    {
        return this.userService.getAllUsers();
    }
    @Operation(summary = "Get user by identifier",
            description = "Provides specific user by ID")
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") Long id)
    {
        return this.userService.getUserById(id);
    }
    @Operation(summary = "save user",
            description = "save a new user")
    @PostMapping("")
    public void saveOwner(@RequestBody UserRequest user)
    {
        this.userService.saveUser(user);
    }
    @Operation(summary = "Delete user",
            description = "Delete user by ID")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id")Long id)
    {
        this.userService.deleteUser(id);
    }

    @Operation(summary = "Get Connected user Details",
    description = "Provides connected user")
@GetMapping("/main-profile")
    public User getConnectedUser(){
        return this.userService.getConnectedUser();
    }
}
