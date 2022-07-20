package com.example.movie.Controller;

import com.example.movie.Api.BoxOfficeApi;

import com.example.movie.Domain.MemberDTO;
import com.example.movie.Domain.MoviesResponseDto;
import com.example.movie.Domain.ReserveDTO;
import com.example.movie.Entity.Member;
import com.example.movie.Entity.Movie;
import com.example.movie.Entity.Reserve;
import com.example.movie.Entity.Schedule;
import com.example.movie.Repository.DailyMovieRepository;
import com.example.movie.Repository.MemberRepository;
import com.example.movie.Repository.ScheduleRepository;
import com.example.movie.Service.MemberService;
import com.example.movie.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    BoxOfficeApi api;
    @Autowired
    MovieService movieService;


    @GetMapping("/")
    public String getMain(Model model,@RequestParam(required = false,defaultValue = "") String searchMovie){
        api.dailyBoxOffice();
        //List<Movie> movieList = dailyMovieRepository.findAll();
        List<Movie> movieList = dailyMovieRepository.findByMovieNmContaining(searchMovie);



        System.out.println(movieList);
        model.addAttribute("movieList", movieList);

        return "index";
    }


    @RequestMapping("/reserve/{idx}")
    public String getReserve(@PathVariable("idx") String movieCd, Model model, HttpSession session){
        Movie movie = dailyMovieRepository.findMovieByMovieCd(movieCd);
        List<String> dateList = scheduleRepository.getDateByMovieCd(movieCd);
        //List<String> timeList = scheduleRepository.getTimeByMovieCd();
        System.out.println(dateList);
        MemberDTO member = (MemberDTO) session.getAttribute("login");
        model.addAttribute("date", dateList);
        model.addAttribute("time", timeList);
        model.addAttribute("movie", movie);
        model.addAttribute("member", member);
        model.addAttribute("reserve", ReserveDTO.builder().build());
        return "reserve";
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
/*  수정해야하는 거.,...
    @GetMapping("/movie/{keyword}")
    public String getSearch(@PathVariable String keyword, Model model){
        //MoviesResponseDto naver =  movieService.findByKeyword(keyword);
        model.addAttribute("naver",movieService.findByKeyword(keyword));
        return "/moviesearch";
    }
*/

}
