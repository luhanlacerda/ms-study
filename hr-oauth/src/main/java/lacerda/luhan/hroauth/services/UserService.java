package lacerda.luhan.hroauth.services;

import lacerda.luhan.hroauth.entities.User;
import lacerda.luhan.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {

        try {
            User user = userFeignClient.findByEmail(email).getBody();

            return user;
        } catch (Exception e) {
            //TODO loggar
            return null;
        }

    }
}
