package com.example.movie;

import com.example.movie.Api.BoxOfficeApi;
import com.example.movie.Entity.Cinema;
import com.example.movie.Entity.Movie;
import com.example.movie.Repository.CinemaRepository;
import com.example.movie.Repository.DailyMovieRepository;
import com.example.movie.Service.CinemaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MovieApplicationTests {

    @Autowired
    BoxOfficeApi api;
    @Autowired
    DailyMovieRepository dailyMovieRepository;
    @Autowired
    CinemaService cinemaService;
    @Test
    void contextLoads() {
        api.dailyBoxOffice();
        List<Movie> movieList =  dailyMovieRepository.findAll();
        System.out.println(movieList);

    }

    @Test
    void test1() {
        Cinema cinema = Cinema.builder()
                .ci_no(5L)
                .name("test1")
                .seat("")
                .build();
    cinemaService.create(cinema, 5, 5);
    }

    @Test
    void test2(){
        List<Cinema> cinemaList = cinemaService.readAll();
        System.out.println(cinemaList);
    }

}
