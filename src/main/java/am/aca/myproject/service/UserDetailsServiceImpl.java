package am.aca.myproject.service;

import am.aca.myproject.builder.UserBuilder;
import am.aca.myproject.entity.song.User;
import am.aca.myproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException("User Nod Found with username:" + username));

        return UserBuilder.build(user);
    }
}
