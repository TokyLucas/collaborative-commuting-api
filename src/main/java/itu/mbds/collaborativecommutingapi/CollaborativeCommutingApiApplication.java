package itu.mbds.collaborativecommutingapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class CollaborativeCommutingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollaborativeCommutingApiApplication.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/swagger-ui/index.html";
    }
}
