package com.example.movie.Controller;

import com.example.movie.Api.BoxOfficeApi;
import com.example.movie.Domain.MemberDTO;
import com.example.movie.Domain.ReserveDTO;
import com.example.movie.Entity.Member;
import com.example.movie.Entity.Movie;
import com.example.movie.Entity.Reserve;
import com.example.movie.Repository.DailyMovieRepository;
import com.example.movie.Repository.MemberRepository;
import com.example.movie.Service.MemberService;
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
    BoxOfficeApi api;
    @GetMapping("/")
    public String getMain(Model model){
        api.dailyBoxOffice();
        List<Movie> movieList = dailyMovieRepository.findAll();
        System.out.println(movieList);
        model.addAttribute("movieList", movieList);
        return "index";
    }


    @RequestMapping("/reserve/{idx}")
    public String getReserve(@PathVariable("idx") String movieCd, Model model){
        Movie movie = dailyMovieRepository.findMovieByMovieCd(movieCd);
        model.addAttribute("movie", movie);
        model.addAttribute("reserve", ReserveDTO.builder().build());
        return "reserve";
    }

    @PostMapping("/reserve/reservation")
    public String makeReserve(@ModelAttribute("reserve") ReserveDTO reserveDTO, Model model, HttpSession session){


        return "redirect:/reserve/complete";
    }




}
