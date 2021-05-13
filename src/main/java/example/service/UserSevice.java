package example.service;

import example.repos.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSevice implements UserDetailsService {
    //@Autowired
    private final UserRepo userRepo;

    public UserSevice(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
}
