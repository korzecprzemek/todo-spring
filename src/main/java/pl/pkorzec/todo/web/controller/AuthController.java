package pl.pkorzec.todo.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pkorzec.todo.application.UserService;
import pl.pkorzec.todo.web.dto.LoginRequest;
import pl.pkorzec.todo.web.dto.RegisterUserRequest;
import pl.pkorzec.todo.web.dto.UserResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody RegisterUserRequest req){
        userService.signUp(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponse> logIn(@RequestBody LoginRequest req){
        return ResponseEntity.ok(userService.logIn(req));
    }
}
