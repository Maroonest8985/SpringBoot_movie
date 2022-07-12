package com.example.movie;

import com.example.movie.Api.BoxOfficeApi;
import com.example.movie.Entity.Movie;
import com.example.movie.Repository.DailyMovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Scanner;

@SpringBootTest
class MovieApplicationTests {

    @Autowired
    BoxOfficeApi api;
    @Autowired
    DailyMovieRepository dailyMovieRepository;

    @Test
    void contextLoads() {
        api.dailyBoxOffice();
        List<Movie> movieList = dailyMovieRepository.findAll();
        System.out.println(movieList);
    }
}
