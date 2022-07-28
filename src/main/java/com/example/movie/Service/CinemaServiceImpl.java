package com.example.movie.Service;

import com.example.movie.Domain.CinemaDTO;
import com.example.movie.Entity.Cinema;
import com.example.movie.Repository.CinemaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        for(int i = 0; i <= x-1; i++){ // 0
            char a = (char) (65+i);
            for(int k = 1; k <= y; k++){ //
                seatArr = seatArr+""+a+""+k+", ";//[0,0]],[0,1]],[0,2]],[0,3]],[0,4]]
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
    public CinemaDTO findById(Long id){
        Cinema cinema = cinemaRepository.findById(id).orElse(null);

        CinemaDTO cinemaDTO = entityToDto(cinema);
        return cinemaDTO;
    }

    @Override
    public void update(CinemaDTO cinema) {
        String[] strArray = cinema.getSeat().split(", ");
        // update를 할때 배열로 된 seat를 사용하고싶어
        // 화면에 띄우고싶다 -> 프론트에
        // 컨트롤러에서 뷰에 보내는 정보는 배열로 된 정보를 보내
        // 그 배열을 프론트에서 for문을 돌리는거임
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
