package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.UserService;
import org.sweetrooms.persistence.entities.User;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Api(value = "Restfull APIs for user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("")
    public List<User> getAllUsers()
    {
        return this.userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(name = "id") Long id)
    {
        return this.userService.getUserById(id);
    }
    @PostMapping("")
    public User saveUser(User user)
    {
        return this.userService.saveUser(user);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id")Long id)
    {
        this.userService.deleteUser(id);
    }
}
