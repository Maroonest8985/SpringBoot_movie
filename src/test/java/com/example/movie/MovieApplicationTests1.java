package com.example.movie;

import com.example.movie.Api.BoxOfficeApi;
import com.example.movie.Entity.Movie;
import com.example.movie.Repository.DailyMovieRepository;
import com.example.movie.Service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
class MovieApplicationTests1 {

    @Autowired
    BoxOfficeApi api;
    @Autowired
    DailyMovieRepository dailyMovieRepository;
    @Autowired
    ScheduleService service;
    @Test
    void contextLoads() throws ParseException {
        String movieCd = "20205362";
        String date = "2022-07-25";
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dated = transFormat.parse(date);
        System.out.println(dated);
        System.out.println(service.getTime(movieCd, dated));
    }
}
