package com.gulukal.restwebservices.user;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserJPAResource {

    //@Autowired
    private final UserRepository userRepository;

    public UserJPAResource(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    //GET
    // /users
    //retrieveAllUsers

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    //GET
    // /users/1
    //retrieveUser(int id)
    @GetMapping("/jpa/users/{id}")
    public ResponseEntity<User> retrieveUser(@PathVariable(value = "id") int id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Instructor not found :: " + id));
        return ResponseEntity.ok().body(user);
    }

    //DELETE

    @DeleteMapping("/jpa/users/{id}")
    public Map<String, Boolean> deleteUser(
            @PathVariable(value = "id") int id) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + id));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    //CREATED
    //input-created & return the created URI
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);

        // CREATED
        // /user/{id}  saveduser.getId
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping("/jpa/users/{id}")
    public ResponseEntity<User> updateUser(
            @PathVariable(value = "id") int id,
            @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found :: " + id));
        user.setName(userDetails.getName());
        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }
}