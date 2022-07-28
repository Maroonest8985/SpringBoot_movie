package com.example.movie.Service;


import com.example.movie.Domain.CinemaDTO;
import com.example.movie.Entity.Cinema;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;

@Service
public interface CinemaService {
    void create(CinemaDTO cinema, int x, int y);
    String seat(Long no);
    List<Cinema> readAll();
}
