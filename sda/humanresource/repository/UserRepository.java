package pl.sda.humanresource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.humanresource.repository.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

}
