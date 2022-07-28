package com.example.movie;

import com.example.movie.Api.BoxOfficeApi;
import com.example.movie.Entity.Movie;
import com.example.movie.Repository.DailyMovieRepository;
import com.example.movie.Repository.MemberRepository;
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
    MemberRepository memberRepository;

    @Test
    void contextLoads() {
        api.dailyBoxOffice();
        List<Movie> movieList = dailyMovieRepository.findAll();
        System.out.println("결과 ----------------->"+movieList);
    }

    @Test
    public void seatTest() {
        String seatArr = "";
        String seat = null;
        for(int i = 0; i <= 10-1; i++){ // 0
            char a = (char) (65+i);
            for(int k = 1; k <= 10; k++){ //
                seatArr = seatArr+""+a+""+k+", ";//[0,0]],[0,1]],[0,2]],[0,3]],[0,4]]
            }
        }

        String[] strArray = seatArr.split(", ");//"[0,1], [0,2], [0,3]..."

        for(int i=0;i<strArray.length;i++) { //출력
            System.out.println(strArray[i]);
        }
    }
}
