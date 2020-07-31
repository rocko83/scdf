//package br.com.clusterlab.feignclient02.controller;
//
//import br.com.clusterlab.feignclient02.client.PostClient;
//import br.com.clusterlab.feignclient02.dto.Post;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.openfeign.EnableFeignClients;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//
//@EnableFeignClients
//@RestController
//public class PostController {
//
//    @Autowired
//    private PostClient post;
//
//    @GetMapping("/post")
//    public List<Post> getAllPosts() {
//        return post.getPosts();
//    }
//}
