package lacerda.luhan.hroauth.services;

import lacerda.luhan.hroauth.entities.User;
import lacerda.luhan.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient userFeignClient;

    // Apenas didático
    public User findByEmail(String email) {
        try {
            User user = userFeignClient.findByEmail(email).getBody();

            return user;
        } catch (Exception e) {
            //TODO loggar
            return null;
        }
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            User user = userFeignClient.findByEmail(s).getBody();
            if (user == null) {
                throw new UsernameNotFoundException("Email not found");
            } else {
                return user;
            }
        } catch (Exception e) {
            //TODO loggar
            return null;
        }
    }
}
