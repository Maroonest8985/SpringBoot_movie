package com.example.movie.Repository;

import com.example.movie.Entity.Member;
import com.example.movie.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface DailyMovieRepository extends JpaRepository<Movie, Long> {

    @Query("delete from Movie m where m.targetDt < :targetDt")
    long deleteAllWithTarget(@Param("targetDt") String targetDt);

    @Transactional
    @Modifying
    long deleteMoviesByTargetDtNotLike(String targetDt);


    List<String> findAllByMovieCd(String movieCd);
    Movie findMovieByMovieCd(String movieCd);
    List<String> findAllByTargetDt(String targetDt);


}
