package br.com.tech.challenge.controllers;

import br.com.tech.challenge.dto.UserDTO;
import br.com.tech.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody UserDTO dto){

        Long id = service.createUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(String.valueOf(id));

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") Long userId){
        UserDTO user = service.getUser(userId);

        if (Objects.nonNull(user)){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable(name = "id") Long userId, @RequestBody UserDTO userDTO){

        UserDTO dto = service.updateUser(userDTO, userId);

        if (Objects.nonNull(dto)){
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") Long userId){

        if (service.deleteUser(userId)){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

}
