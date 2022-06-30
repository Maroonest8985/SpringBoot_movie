package com.example.movie.Controller;

import com.example.movie.Domain.MemberDTO;
import com.example.movie.Service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/regform")
    public String getRegform(Model model) {
        model.addAttribute("member", MemberDTO.builder().build());
        return "/member/regform";
    }

    @PostMapping("")
    public String postMember(@ModelAttribute("member") MemberDTO memberDTO) {
        memberService.create(memberDTO);
        return "redirect:/";
    }

    @GetMapping("/{idx}")
    public String getMember(@PathVariable("idx") Long no, Model model) {
        MemberDTO memberDTO = memberService.readById(no);
        model.addAttribute("member", memberDTO);
        return "/member/read";
    }

    @GetMapping("/login")
    public String getLoginform(Model model) {
        model.addAttribute("member", MemberDTO.builder().build());
        return "/member/login";
    }

    @PostMapping("/login")
    public String getLogin(@ModelAttribute("memberDTO") MemberDTO memberDTO, HttpServletRequest request) {
        MemberDTO dto = null;
        if ((dto = memberService.loginById(memberDTO)) != null) {
            HttpSession session = request.getSession();
            session.setAttribute("login", dto);
            return "redirect:/";
        } else
            return "/member/loginfail";
    }
    @GetMapping("/logout")
    public String getLogout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
