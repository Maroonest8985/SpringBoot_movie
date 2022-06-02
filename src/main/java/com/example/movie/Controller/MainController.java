package com.example.movie.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("/main")
    public String getMain(){
        return "index";
    }
}
