package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers()
    {
        return this.userRepository.findAll();
    }

    public User getUserById(Long id)
    {
        return this.userRepository.getById(id);
    }
    public User saveUser(User user)
    {
        return this.userRepository.save(user);
    }
    public void deleteUser(Long id)
    {
        this.userRepository.deleteById(id);
    }
}
