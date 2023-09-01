package br.com.tech.challenge.service;

import br.com.tech.challenge.dto.UserDTO;
import br.com.tech.challenge.entities.UserEntity;


public interface UserService {

    Long createUser(UserDTO userDTO);

    UserDTO getUser(Long id);

    UserDTO updateUser(UserDTO userDTO, Long id);

    boolean deleteUser(Long id);
}
