package br.com.tech.challenge.repository;

import br.com.tech.challenge.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    UserEntity save(UserEntity user);

    Optional<UserEntity> findById(Long id);

    boolean existsById(Long id);
}
