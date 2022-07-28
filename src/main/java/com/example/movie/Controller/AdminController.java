package com.example.movie.Controller;

import com.example.movie.Domain.CinemaDTO;
import com.example.movie.Domain.MemberDTO;

import com.example.movie.Entity.Cinema;
import com.example.movie.Repository.CinemaRepository;
import com.example.movie.Service.CinemaService;
import com.example.movie.Service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final MemberService memberService;
    private final CinemaService cinemaService;
    private final CinemaRepository cinemaRepository;
    // 생성자 주입 : (Constructor Injection) vs. @Autowired
    public AdminController(MemberService memberService, CinemaService cinemaService, CinemaRepository cinemaRepository) {
        this.memberService = memberService;
        this.cinemaService = cinemaService;
        this.cinemaRepository = cinemaRepository;
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
    public String getCinema(@ModelAttribute("cinema") CinemaDTO cinema, Model model)
    {
        model.addAttribute("cinema",cinemaService.readAll());
        return "/admin/cinemalist";
    }

    @GetMapping("/ciadd")
    public String getCiadd(Model model) {
        model.addAttribute("cinema", CinemaDTO.builder().build());
        return "/admin/ciadd";
    }

    @PostMapping("/cinemaadd")
    public String postCinema1(@ModelAttribute("cinema") CinemaDTO cinema, HttpServletRequest request, Model model){
        int x = Integer.parseInt(request.getParameter("x"));
        int y = Integer.parseInt(request.getParameter("y"));
        cinemaService.create(cinema, x, y);

        return "redirect:/admin/cinemalist";
    }

    @GetMapping("/cinemalist/{ci_no}")
    public String getUpdate(@PathVariable("ci_no")Long ci_no,CinemaDTO cinema, Model model)
    {
        //cinemaService.update();
        model.addAttribute(cinema);
        return "/admin/ciupdate";
    }
    //리파람 -> /member/1 -> 패스변수 /// /member?id=1 -> 리파람
    //모덜 -> form으로 데이터를 전송할때 Model 형식으로 받고싶을때 ->
    //스루패스 -> /member/1 -> 1을 {변수명} 으로 치환해줌
    @GetMapping("/{ci_no}")
    public String getDetail(@PathVariable("ci_no") Long id, Model model){
        CinemaDTO cinemaDTO = cinemaService.findById(id);
        //cinema에 접근해서 seat 정보만 빼 -> 이건 String형으로 빠지겠지
        //뷰에 그냥 스트링형으로 보내버려
        //근데 JS에서 짤라
        model.addAttribute("cinema", cinemaDTO);

        return "/admin/detailTest";
    }

    // 임시 좌석 보기
    @GetMapping("/seat")
    public String getSeat(){
        return "/admin/seatTest";
    }


}
