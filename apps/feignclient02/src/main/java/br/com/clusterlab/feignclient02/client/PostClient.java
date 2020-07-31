package br.com.clusterlab.feignclient02.client;

import br.com.clusterlab.feignclient02.dto.PostResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com/",name = "POST-CLIENT")
public interface PostClient {
    @GetMapping("/posts")
    public List<PostResponse> getPosts();
}
