package com.example.movie.Service;

import com.example.movie.Domain.CinemaDTO;
import com.example.movie.Entity.Cinema;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public interface CinemaService {
    void create(Cinema cinema, int x, int y);
    String[] seat(String seatArr);
    List<Cinema> readAll();

}
