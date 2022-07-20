package com.example.movie;

import com.example.movie.Entity.Member;
import com.example.movie.Repository.MemberRepository;
import com.example.movie.Service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemberTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Test
    void memberReg(){

        System.out.println("ffff");
    }
}
