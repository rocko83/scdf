package br.com.clusterlab.feignclient02.client;

//import br.com.clusterlab.feignclient02.config.ClientConfiguration;
import br.com.clusterlab.feignclient02.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(url = "https://jsonplaceholder.typicode.com/", name = "USER-CLIENT")
public interface UserClient {
    @GetMapping("/users")
    public List<UserResponse> getUsers();

}
