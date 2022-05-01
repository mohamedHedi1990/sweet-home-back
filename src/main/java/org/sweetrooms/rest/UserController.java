package org.sweetrooms.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.sweetrooms.business.services.SecurityService;
import org.sweetrooms.business.services.UserService;
import org.sweetrooms.business.services.email.EmailService;
import org.sweetrooms.client.dtos.request.PasswordDtoRequest;
import org.sweetrooms.client.dtos.request.UserRequest;
import org.sweetrooms.client.dtos.response.UserDetailsResponse;
import org.sweetrooms.persistence.entities.User;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@RequestMapping("/user")
@Tag(description = "Restfull APIs for user", name = "user ressource")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	SecurityService securityService;
@Autowired
EmailService mailSender;
	@Operation(summary = "Get users", description = "Provides all available users list")
	@GetMapping("")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@Operation(summary = "Get user by identifier", description = "Provides specific user by ID")
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(name = "id") Long id) {
		return this.userService.getUserById(id);
	}

	@Operation(summary = "save user", description = "save a new user")
	@PostMapping("/add-new-user")
	public void saveOwner(@RequestBody UserRequest user) {
		this.userService.saveUser(user);
	}

	@Operation(summary = "Delete user", description = "Delete user by ID")
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable(name = "id") Long id) {
		this.userService.deleteUser(id);
	}

	@Operation(summary = "Get Connected user Details", description = "Provides connected user")
	@GetMapping("/user-info")
	public UserDetailsResponse getUserInfo() {
		return this.userService.getUserInfo();
	}
	
	@Operation(summary = "Update user information")
	@PatchMapping("/update-user")
	public void patchUser(@RequestBody UserRequest userRequest){
		this.userService.patchUser(userRequest);
	}
	
	@PostMapping("/resetPassword")
	public ResponseEntity<String> resetPassword(
			@RequestBody String userEmail) {
	    User user = userService.findUserByEmail(userEmail);
	    if (user == null) {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }else
	    {
	    	securityService.forgetPassword(user);
	    }
	    
	   return new ResponseEntity<>(HttpStatus.OK);
	}
	@GetMapping("/changePassword")
	public ResponseEntity<String> showChangePasswordPage( @RequestParam("token") String token) {
	    String result = securityService.validatePasswordResetToken(token);
	    if(result != null) {
	    	return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	@PostMapping("/savePassword")
	public ResponseEntity<String> savePassword(@Valid PasswordDtoRequest passwordDto) {

	    String result = securityService.validatePasswordResetToken(passwordDto.getToken());

	    if(result != null) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }

	    User user = securityService.getUserByPasswordResetToken(passwordDto.getToken()).orElse(null);
	    if(user !=null) {
	    	userService.changeUserPassword(user, passwordDto.getNewPassword());
	    	  return new ResponseEntity<>(HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
	    }
	}
}
