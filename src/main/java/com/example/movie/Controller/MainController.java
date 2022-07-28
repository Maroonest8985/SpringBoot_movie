package com.example.movie.Controller;

import com.example.movie.Api.BoxOfficeApi;

import com.example.movie.Domain.MemberDTO;
import com.example.movie.Domain.MoviesDto;
import com.example.movie.Domain.MoviesResponseDto;
import com.example.movie.Domain.ReserveDTO;
import com.example.movie.Entity.Member;
import com.example.movie.Entity.Movie;
import com.example.movie.Entity.Reserve;
import com.example.movie.Repository.DailyMovieRepository;
import com.example.movie.Repository.MemberRepository;
import com.example.movie.Repository.ScheduleRepository;
import com.example.movie.Service.CinemaService;
import com.example.movie.Service.MemberService;
import com.example.movie.Service.MovieService;
import com.example.movie.Service.ScheduleService;
import com.nimbusds.oauth2.sdk.util.date.SimpleDate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    DailyMovieRepository dailyMovieRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;
    @Autowired
    ScheduleRepository scheduleRepository;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    BoxOfficeApi api;
    @Autowired
    MovieService movieService;
    @Autowired
    CinemaService cinemaService;

    @GetMapping("/")
    public String getMain(Model model,@RequestParam(required = false,defaultValue = "") String searchMovie){
        api.dailyBoxOffice();
        //List<Movie> movieList = dailyMovieRepository.findAll();
        List<Movie> movieList = dailyMovieRepository.findByMovieNmContaining(searchMovie);


        System.out.println(movieList);
        model.addAttribute("movieList", movieList);

        return "index";
    }


    @GetMapping("/reserve/{idx}")
    public String getReserve(@PathVariable("idx") String movieCd, Model model, HttpSession session){
        Movie movie = dailyMovieRepository.findMovieByMovieCd(movieCd);
        List<String> dateList = new ArrayList<>();
        dateList = scheduleService.getDate(movieCd);
        System.out.println(dateList);
        MemberDTO member = (MemberDTO) session.getAttribute("login");

        model.addAttribute("date", dateList);
        //model.addAttribute("time", timeList);
        model.addAttribute("movie", movie);
        model.addAttribute("member", member);
        model.addAttribute("reserve", ReserveDTO.builder().build());
        return "reserve";
    }


    @RequestMapping(value = "/reserve/getTime", method=RequestMethod.GET)
    @ResponseBody
    public ArrayList<String> getTimes(@RequestParam("moviecd") String movieCd, @RequestParam("date") String date) throws ParseException {
        System.out.println("ajax 작동중" + date);
        System.out.println("ajax 작동중" + movieCd);
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dated = transFormat.parse(date);
        System.out.println(scheduleService.getTime(movieCd, dated));
        ArrayList<String> dates = scheduleService.getTime(movieCd, dated);
        System.out.println("ajax 작동중" + dates);
        return dates;
    }

    @RequestMapping(value = "/reserve/getCinema", method=RequestMethod.GET)
    @ResponseBody
    public String getCinema(@RequestParam("moviecd") String movieCd, @RequestParam("time") String time, @RequestParam("date") String date) throws ParseException {
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat transFormatTime = new SimpleDateFormat("HH:mm:ss");

        Date dated = transFormat.parse(date);
        Date timed = transFormatTime.parse(time);
        Long ci_no = scheduleRepository.findCinemaByMoviecdAndDateAndTime(movieCd, dated, timed);
        String seat = cinemaService.seat(ci_no);//상영관 좌석정보
        //예약된 좌석정보 Reserve에서 가져옴

        return seat;
    }


    @PostMapping("/reserve/reservation")
    public String makeReserve(@ModelAttribute("reserve") ReserveDTO reserveDTO, Model model, HttpSession session){


        return "redirect:/reserve/complete";
    }

    @GetMapping("/detail/{idx}")
    public String getDetail(@PathVariable("idx") Long id,Model model){
        Movie movie = dailyMovieRepository.findById(id).get();
        //MoviesResponseDto naver = movieService.findByKeyword(movie);
        model.addAttribute("movie",movie);
        return "detail";
    }


    @GetMapping("/movies/{keyword}")
    public String getSearch(@PathVariable String keyword, Model model) throws com.nimbusds.jose.shaded.json.parser.ParseException {
        MoviesDto naver = movieService.findByKeyword2(keyword);
        System.out.println(naver);
        model.addAttribute("naver", naver);
        return "moviesearch";
    }

}
