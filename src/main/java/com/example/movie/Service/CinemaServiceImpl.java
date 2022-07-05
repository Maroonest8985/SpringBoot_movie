package com.example.movie.Service;


import com.example.movie.Domain.MemberDTO;
import com.example.movie.Entity.Member;
import com.example.movie.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionalException;
import java.lang.reflect.Array;
import java.util.Optional;

@Service
public class CinemaServiceImpl implements CinemaService{
    private final MemberRepository memberRepository;

    public CinemaServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void insertSeat(Array arr){

    }


}
