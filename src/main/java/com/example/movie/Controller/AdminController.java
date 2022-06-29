package com.example.movie.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/home")
    public String getHome(){
        return "/admin/home";
    }

    @GetMapping("/list")
    public String getList(){
        return "/admin/list";
    }

    @GetMapping("/regform")
    public String getRegform(){
        return "/admin/regform";
    }

    @GetMapping("/upform")
    public String getUpform(){
        return "/admin/upform";
    }

    @GetMapping("/detail")
    public String getDetail(){
        return "/admin/detail";
    }

}
