package com.example.movie.Service;

import com.example.movie.Domain.CinemaDTO;
import com.example.movie.Entity.Cinema;
import com.example.movie.Repository.CinemaRepository;
import org.springframework.stereotype.Service;

@Service
public class CinemaServiceImpl implements CinemaService{
    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public void create(CinemaDTO cinema) {
        Cinema entity = dtoToEntity(cinema);
        cinemaRepository.save(entity);
    }

    public Cinema dtoToEntity (CinemaDTO cinema){
        Cinema entity = Cinema.builder()
                .ci_no(cinema.getCi_no())
                .seat(cinema.getSeat())
                .build();
        return entity;
    }

    public CinemaDTO entityToDto(Cinema entity){
        CinemaDTO cinemaDTO = CinemaDTO.builder()
                .ci_no(entity.getCi_no())
                .seat(entity.getSeat())
                .build();
        return cinemaDTO;
    }
}
