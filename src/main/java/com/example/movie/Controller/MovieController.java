package com.example.movie.Controller;

import com.example.movie.Domain.MoviesResponseDto;
import com.example.movie.Service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@Controller
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;


    @GetMapping("/movie/{keyword}")
    public MoviesResponseDto get(@PathVariable String keyword){
        return movieService.findByKeyword(keyword);
    }



}
