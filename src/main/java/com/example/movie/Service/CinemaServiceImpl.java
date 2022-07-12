package com.example.movie.Service;

import com.example.movie.Domain.CinemaDTO;
import com.example.movie.Entity.Cinema;
import com.example.movie.Repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService{
    private final CinemaRepository cinemaRepository;

    public CinemaServiceImpl(CinemaRepository cinemaRepository) {
        this.cinemaRepository = cinemaRepository;
    }

    @Override
    public void create(CinemaDTO cinema, int x, int y) {

        String seatArr = "";
        String seat = null;
        for(int i = 0; i <= x; i++){ // 0
            for(int k = 0; k <= y; k++){ //
                seatArr = seatArr+"{"+i+","+k+"}],";//[0,0]],[0,1]],[0,2]],[0,3]],[0,4]]
            }
        }

        Cinema entity = Cinema.builder()
                .ci_no(cinema.getCi_no())
                .name(cinema.getName())
                .seat(seatArr)
                .build();
        cinemaRepository.save(entity);
    }

    @Override
    public List<Cinema> readAll(){
        List<Cinema> cinemaList = cinemaRepository.findAll();
        return cinemaList;
    }


    @Override
    public String[] seat(String seatArr){
        String[] strArray = seatArr.split("], ");//"[0,1], [0,2], [0,3]..."
        return strArray;
    }


    public void create1(CinemaDTO cinema) {
        Cinema entity = dtoToEntity(cinema);
        cinemaRepository.save(entity);
    }

    public Cinema dtoToEntity (CinemaDTO cinema){
        Cinema entity = Cinema.builder()
                .ci_no(cinema.getCi_no())
                .name(cinema.getName())
                .seat(cinema.getSeat())
                .build();
        return entity;
    }

    public CinemaDTO entityToDto(Cinema entity){
        CinemaDTO cinemaDTO = CinemaDTO.builder()
                .ci_no(entity.getCi_no())
                .name(entity.getName())
                .seat(entity.getSeat())
                .build();
        return cinemaDTO;
    }
}
