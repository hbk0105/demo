package api.backend.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;

// TestController.java
@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class TestController {

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRequest request) {
        User user = null;
        try{
             user = userRepository.save(request.toEntity());
        }catch (Exception e){
            e.printStackTrace();

        }finally {
            return ResponseEntity.created(URI.create("/users/" + user.getId())).build();
        }


    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        return ResponseEntity.ok(
                userRepository.findAll()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(
                userRepository.findById(id)
                        .orElseThrow(IllegalStateException::new)
        );
    }
}
