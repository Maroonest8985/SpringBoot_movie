package com.example.movie.Service;


import com.example.movie.Domain.MemberDTO;
import com.example.movie.Entity.Member;
import com.example.movie.Repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void create(MemberDTO member) {
        Member entity = dtoToEntity(member);
        memberRepository.save(entity);
    }

    private Member dtoToEntity(MemberDTO member) {
        Member entity = Member.builder()
                .no(member.getNo())
                .address(member.getAddress())
                .birth(member.getBirth())
                .email(member.getEmail())
                .id(member.getId())
                .username(member.getUsername())
                .password(member.getPassword())
                .phone(member.getPhone())
                .build();
        return entity;
    }
}
