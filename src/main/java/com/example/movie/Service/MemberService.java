package com.example.movie.Service;


import com.example.movie.Domain.MemberDTO;
import com.example.movie.Entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface MemberService {
    List<Member> readAll();
    MemberDTO readById(Long no);
    void create(MemberDTO member);
    void update(MemberDTO memberDTO);
    void delete(MemberDTO memberDTO);
}
