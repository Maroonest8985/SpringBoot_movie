package com.example.movie.Repository;


import com.example.movie.Entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {


    @Query("select c.seat from Cinema c where c.ci_no = :no")
    String getSeatString(@Param("no") Long no);
}
