package timski.proekt.backend.Service.Impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import timski.proekt.backend.Model.User;
import timski.proekt.backend.exceptions.InvalidUserIdException;
import timski.proekt.backend.Repository.UserRepository;
import timski.proekt.backend.Service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(InvalidUserIdException::new);
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(Long id, String email, String password) {
        User user = this.findById(id);
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }


    //public class UserServiceImpl implements UserService, UserDetailsService
    //{
    //    @Autowired
    //    private UserRepository userRepository;
    //    @Autowired
    //    private PasswordEncoder passwordEncoder;
    //    @Override
    //    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //        User u = userRepository.findByUsername(username);
    //        if(u==null)
    //        {
    //            throw new UsernameNotFoundException(username);
    //        }
    //
    //        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
    //                u.getUsername(),
    //                u.getPassword(),
    //                Stream.of(new SimpleGrantedAuthority(u.getRole())).collect(Collectors.toList()));
    //        return userDetails;
    //    }
    //}
    //              OD WP
}
