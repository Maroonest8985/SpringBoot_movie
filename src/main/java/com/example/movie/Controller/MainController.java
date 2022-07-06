package com.example.movie.Controller;

import com.example.movie.Api.BoxOfficeApi;
import com.example.movie.Entity.Movie;
import com.example.movie.Repository.DailyMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    DailyMovieRepository dailyMovieRepository;
    @Autowired
    BoxOfficeApi api;
    @GetMapping("/")
    public String getMain(Model model){
        api.dailyBoxOffice();
        List<Movie> movieList = dailyMovieRepository.findAll();
        System.out.println(movieList);
        model.addAttribute("movieList", movieList);
        return "index";
    }

    @GetMapping("/reserve")
    public String getReserve(){

        return "reserve";
    }




}
