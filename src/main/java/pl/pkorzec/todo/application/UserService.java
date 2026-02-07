package pl.pkorzec.todo.application;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.pkorzec.todo.domain.User;
import pl.pkorzec.todo.persistence.UserRepository;
import pl.pkorzec.todo.web.dto.LoginRequest;
import pl.pkorzec.todo.web.dto.RegisterUserRequest;
import pl.pkorzec.todo.web.dto.UserResponse;


@Service
public class UserService {
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public void signUp(RegisterUserRequest req){
        if (userRepository.existsByUsername(req.username())){
            throw new IllegalStateException("User already exists");
        }
        String hash = passwordEncoder.encode(req.password());
        User user = new User(req.username(), hash);
        userRepository.save(user);
    }

    public UserResponse logIn(LoginRequest req){
        User user = userRepository.findByUsername(req.username())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong credentials"));
        if(!passwordEncoder.matches(req.password(), user.getPasswordHash())){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Wrong password");
        }
        return new UserResponse(user.getId(), user.getUsername());
    }
}
