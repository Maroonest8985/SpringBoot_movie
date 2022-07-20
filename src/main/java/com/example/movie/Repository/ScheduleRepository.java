package com.example.movie.Repository;


import com.example.movie.Entity.Cinema;
import com.example.movie.Entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("select distinct s.date from Schedule s where s.movie.movieCd =: movieCd order by s.date")
    List<String> getDateByMovieCd(@Param("movieCd") String movieCd);
    @Query("select distinct s.time from Schedule s where s.movie.movieCd =: movieCd and s.date =: date order by s.time")
    List<String> getTimeByMovieCd(@Param("movieCd") String movieCd, @Param("date") String time);
}
