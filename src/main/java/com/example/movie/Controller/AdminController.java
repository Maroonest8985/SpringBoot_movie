package com.example.movie.Controller;

import com.example.movie.Domain.CinemaDTO;
import com.example.movie.Domain.MemberDTO;
import com.example.movie.Service.CinemaService;
import com.example.movie.Service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MemberService memberService;
    private final CinemaService cinemaService;
    // 생성자 주입 : (Constructor Injection) vs. @Autowired
    public AdminController(MemberService memberService, CinemaService cinemaService) {
        this.memberService = memberService;
        this.cinemaService = cinemaService;
    }

    @GetMapping("/home")
    public String getHome(){
        return "/admin/home";
    }

    @GetMapping("/list")
    public String getList(){
        return "/admin/list";
    }

    @GetMapping("/regform")
    public String getRegform(Model model){
        model.addAttribute("member", MemberDTO.builder().build());
        return "/admin/regform";
    }
    @PostMapping("")
    public String postMember(@ModelAttribute("member") MemberDTO member, Model model){
        memberService.create(member);
        return "/admin/list";
        //return "/members/"+ member.getClass() +"/upform";
    }

    @GetMapping("/cinemalist")
    public String getCinema() {return "/admin/cinemalist";}

    @GetMapping("/ciadd")
    public String getCiadd(Model model) {
        model.addAttribute("cinema", CinemaDTO.builder().build());
        return "/admin/ciadd";
    }

    @GetMapping("/upform")
    public String getUpform(){
        return "/admin/upform";
    }

    @GetMapping("/detail")
    public String getDetail(){
        return "/admin/detail";
    }

    // 임시 좌석 보기
    @GetMapping("/seat")
    public String getSeat(){
        return "/admin/seat";
    }

    @GetMapping("/cinema")
    public String getCinema() {return "/admin/cinema";}

}
