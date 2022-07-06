package com.example.movie.Controller;

import com.example.movie.Domain.MemberDTO;
import com.example.movie.Entity.Member;
import com.example.movie.Service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final MemberService memberService;

    public AdminController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/home")
    public String getHome(){
        return "/admin/home";
    }

    @GetMapping("/list")
    public String getList(Model model){
        List<Member> list = memberService.readAll();
        model.addAttribute("list",list);
        return "/admin/list";
    }
    @GetMapping("/detail/{idx}")
    public String getDetail(@PathVariable("idx") Long no, Model model){
        MemberDTO memberDTO = memberService.readById(no);
        model.addAttribute("member", memberDTO);
        return "/admin/detail";
    }

    @GetMapping("/regform")
    public String getRegform(Model model){
        model.addAttribute("member", MemberDTO.builder().build());
        return "/admin/regform";
    }
    @PostMapping("")
    public String postMember(@ModelAttribute("member") MemberDTO member, Model model){
        memberService.create(member);
        return "redirect:/admin/list";
        //return "/members/"+ member.getClass() +"/upform";
    }

    @GetMapping("/upform/{idx}")
    public String getUpform(@PathVariable("idx")Long no,Model model){
        MemberDTO memberDTO = memberService.readById(no);
        model.addAttribute("member",memberDTO);
        return "/admin/upform";
    }
    @PutMapping("/{idx}")
    public String putUpform(@ModelAttribute("member")MemberDTO memberDTO,Model model){
        memberService.update(memberDTO);
        model.addAttribute(memberDTO);
        return "/admin/detail";
    }
    @DeleteMapping("/detail/{idx}")
    public String deleteform(@ModelAttribute("member")MemberDTO memberDTO,Model model){
        memberService.delete(memberDTO);
        model.addAttribute(memberDTO);
        return "redirect:/home";
    }


}
