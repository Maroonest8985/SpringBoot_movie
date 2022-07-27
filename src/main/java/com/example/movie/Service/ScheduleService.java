package com.example.movie.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface ScheduleService {

    ArrayList<String> getDate(String movieCd);
    ArrayList<String> getTime(String movieCd, Date date);
}
