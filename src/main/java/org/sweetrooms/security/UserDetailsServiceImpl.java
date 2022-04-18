package org.sweetrooms.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.sweetrooms.persistence.entities.Role;
import org.sweetrooms.persistence.entities.User;
import org.sweetrooms.persistence.repositories.UserRepository;

import javax.transaction.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String loginUserUSer) throws UsernameNotFoundException {
        User user = userRepository.findByUserEmail(loginUserUSer)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + loginUserUSer));
        return UserDetailsImpl.build(user);
    }

    @Transactional
    public Role getRolesUser(String loginUserUSer) {
        User user = userRepository.findByUserEmail(loginUserUSer)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + loginUserUSer));
        return user.getUserRole();
    }
}