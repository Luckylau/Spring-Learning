package luckylau.spring.security;


import luckylau.spring.entity.UserPO;
import luckylau.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author luckylau
 * @Date 2019/7/13
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPO userPO = userRepository.findByUsername(username);
        if (userPO == null) {
            throw new UsernameNotFoundException(username);
        }

        return new CustomUserDetails(userPO);
    }
}
