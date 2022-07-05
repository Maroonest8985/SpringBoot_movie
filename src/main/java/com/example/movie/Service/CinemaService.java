package com.example.movie.Service;

import com.example.movie.Domain.CinemaDTO;
import org.springframework.stereotype.Service;

@Service
public interface CinemaService {
    void create(CinemaDTO cinema);

}
