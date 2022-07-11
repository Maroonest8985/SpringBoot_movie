package com.example.movie.Repository;


import com.example.movie.Entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
