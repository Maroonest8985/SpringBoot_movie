package com.example.movie.Service;

import com.example.movie.Entity.Schedule;
import com.example.movie.Repository.MemberRepository;
import com.example.movie.Repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.*;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;


    public ScheduleServiceImpl(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ArrayList<String> getDate(String movieCd){
        ArrayList<String> schedule = scheduleRepository.findAllByMoviecdOrderByDateAsc(movieCd);

        return schedule;
    }

    @Override
    public ArrayList<String> getTime(String movieCd, Date date){
        ArrayList<String> schedule = scheduleRepository.findTimeByMoviecdAndDate(movieCd, date);

                return schedule;
    }
    //ArrayList<String> getDate(String movieCd);
    //ArrayList<String> getTime(String movieCd, String date);

}
