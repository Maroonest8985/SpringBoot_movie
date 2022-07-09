package com.example.movie.Repository;

import com.example.movie.Entity.Member;
import com.example.movie.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyMovieRepository extends JpaRepository<Movie, Long> {

    List<String> findAllByMovieCd(String movieCd);
    Movie findMovieByMovieCd(String movieCd);
}
