package com.example.movie.Repository;


import com.example.movie.Entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
