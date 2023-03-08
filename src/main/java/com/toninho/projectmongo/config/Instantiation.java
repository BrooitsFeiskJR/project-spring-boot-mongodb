package com.toninho.projectmongo.config;

import com.toninho.projectmongo.domain.Post;
import com.toninho.projectmongo.domain.User;
import com.toninho.projectmongo.dto.AuthorDTO;
import com.toninho.projectmongo.dto.CommentDTO;
import com.toninho.projectmongo.repository.PostRepository;
import com.toninho.projectmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Rafaela Pavan", "rafaela@gmail.com");
        User u2 = new User(null, "Luiz Antonio", "luiz@gmail.com");
        User u3 = new User(null, "Matheus Rafanhin", "rafanhin@gmail.com");
        User u4 = new User(null, "Igor menezes", "igor@gmail.com");
        User u5 = new User(null, "Rivalda Pavan", "zuca@gmail.com");

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(u1));

        CommentDTO c1 = new CommentDTO("Boa viagem mano", sdf.parse("21/03/2018"), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(u3));
        CommentDTO c3 = new CommentDTO("Tenha um otimo dia", sdf.parse("23/03/2018"), new AuthorDTO(u5));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().add(c3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        u1.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(u1);
    }
}
