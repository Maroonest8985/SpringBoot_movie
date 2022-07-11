package com.example.movie.Service;

import com.example.movie.Domain.CinemaDTO;
<<<<<<< HEAD
import com.example.movie.Entity.Cinema;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public interface CinemaService {
    void create(Cinema cinema, int x, int y);
    String[] seat(String seatArr);
    List<Cinema> readAll();
=======
import org.springframework.stereotype.Service;

@Service
public interface CinemaService {
    void create(CinemaDTO cinema);
>>>>>>> 15f59caa061575b3ddf1aca1e8bfe12eaf879618

}
