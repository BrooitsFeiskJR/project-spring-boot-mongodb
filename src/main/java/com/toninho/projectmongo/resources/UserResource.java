package com.toninho.projectmongo.resources;

import com.toninho.projectmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {

        User u1 = new User("1", "Rafaela Pavan", "rafaela@gmail.com");
        User u2 = new User("2", "Luiz Antonio Pereira", "luiz@gmail.com");

        return ResponseEntity.ok().body(new ArrayList<>(Arrays.asList(u1, u2)));
    }
}
