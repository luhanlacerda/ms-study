package lacerda.luhan.hruser.resources;

import lacerda.luhan.hruser.entities.User;
import lacerda.luhan.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Optional<User> user = repository.findById(id);

        if (user.isPresent())
            return ResponseEntity.ok(user.get());
        else
            return ResponseEntity.notFound().build();

    }

    @GetMapping(value = "/search")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {

        Optional<User> user = repository.findByEmail(email);

        if (user.isPresent())
            return ResponseEntity.ok(user.get());
        else
            return ResponseEntity.notFound().build();

    }

}
