package br.com.tech.challenge.service.impl;

import br.com.tech.challenge.dto.UserDTO;
import br.com.tech.challenge.entities.UserEntity;
import br.com.tech.challenge.repository.UserRepository;
import br.com.tech.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Long createUser(UserDTO userDTO) {
        return userRepository.save(new UserEntity(userDTO)).getId();
    }

    @Override
    public UserDTO getUser(Long id) {
        Optional<UserEntity> entity = userRepository.findById(id);
        return entity.map(UserDTO::new).orElse(null);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Long id) {
        if (userRepository.existsById(id)) {
            UserEntity entity = new UserEntity(userDTO);
            entity.setId(id);
            return new UserDTO(userRepository.save(entity));
        }
        return null;
    }

    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
