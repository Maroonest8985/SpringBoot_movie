package com.example.movie.Controller;

import com.example.movie.Domain.MemberDTO;
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
    // 생성자 주입 : (Constructor Injection) vs. @Autowired
    public AdminController(MemberService memberService) {
        this.memberService = memberService;
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
