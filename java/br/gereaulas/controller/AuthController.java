package br.gereaulas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gereaulas.auth.SecurityUtils;
import br.gereaulas.model.User;
import br.gereaulas.repository.UserRepository;

@RestController
@RequestMapping("/login")
public class AuthController {
	private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public ResponseEntity<String> auth(@RequestBody User authUser) {
        var user = userRepository.findByEmailAndPassword(authUser.getEmail(), authUser.getPassword());
       
        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Username or password invalid");
        }
        
        String token = SecurityUtils.buildJwt(user.getEmail());
        return ResponseEntity.ok(token);
    }
}
