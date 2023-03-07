package com.toninho.projectmongo.config;

import com.toninho.projectmongo.domain.User;
import com.toninho.projectmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User u1 = new User(null, "Rafaela Pavan", "rafaela@gmail.com");
        User u2 = new User(null, "Luiz Antonio", "luiz@gmail.com");
        User u3 = new User(null, "Matheus Rafanhin", "rafanhin@gmail.com");
        User u4 = new User(null, "Igor menezes", "igor@gmail.com");
        User u5 = new User(null, "Rivalda Pavan", "zuca@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
    }
}
