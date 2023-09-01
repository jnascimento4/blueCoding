package br.com.tech.challenge.dto;

import br.com.tech.challenge.entities.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserDTO {

    private String name;

    private String email;

    private Integer age;

    public UserDTO(){}

    public UserDTO(UserEntity entity){
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.age = entity.getAge();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
