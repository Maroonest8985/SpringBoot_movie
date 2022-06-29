package com.example.movie.Service;


import com.example.movie.Domain.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public interface MemberService {
    void create(MemberDTO member);
}
