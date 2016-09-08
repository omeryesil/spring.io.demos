package hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yesiome on 9/6/2016.
 */

@RestController()
@RequestMapping("/api/v1")
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Bootovski";
    }

}
