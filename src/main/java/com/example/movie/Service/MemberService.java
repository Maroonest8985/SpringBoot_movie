package com.example.movie.Service;


import com.example.movie.Domain.MemberDTO;
import com.example.movie.Entity.Member;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MemberService {
    void create(MemberDTO member);
    void update(MemberDTO member);
    MemberDTO readById(Long no);
    MemberDTO loginById(MemberDTO memberDTO);
    void deleteByNo(Long no);
    List<Member> readAll();
    void delete(MemberDTO memberDTO);

}
