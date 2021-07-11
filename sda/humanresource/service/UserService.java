package pl.sda.humanresource.service;

import pl.sda.humanresource.web.model.NewUser;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.humanresource.repository.UserEntity;
import pl.sda.humanresource.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void registerUser(NewUser newUser){
        UserEntity entity = UserEntity.builder()
                .password(passwordEncoder.encode(newUser.getPassword()))
                .username(newUser.getUsername())
                .role(newUser.getRole())
                .build();
        userRepository.save(entity);
    }

}
