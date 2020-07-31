package br.com.clusterlab.feignclient02;

import br.com.clusterlab.feignclient02.client.PostClient;
import br.com.clusterlab.feignclient02.client.UserClient;
import br.com.clusterlab.feignclient02.dto.PostResponse;
import br.com.clusterlab.feignclient02.dto.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@SpringBootApplication
@EnableFeignClients
public class Feignclient02Application {
    @Autowired
    private PostClient posts;
    @Autowired
    private UserClient users;

    @GetMapping("/post")
    public List<PostResponse> getAllPosts() {
        return posts.getPosts();
    }
    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
//        List<UserResponse> teste = users.getUsers();
        return users.getUsers();
    }
    public static void main(String[] args) {
        SpringApplication.run(Feignclient02Application.class, args);
    }

}
