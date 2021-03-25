package lacerda.luhan.hroauth.resources;

import lacerda.luhan.hroauth.entities.User;
import lacerda.luhan.hroauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping(value = "/search")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {
        try {
            User user = service.findByEmail(email);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else
                return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
