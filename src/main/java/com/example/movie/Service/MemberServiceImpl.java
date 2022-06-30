package com.example.movie.Service;


import com.example.movie.Domain.MemberDTO;
import com.example.movie.Entity.Member;
import com.example.movie.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    @Override
    public MemberDTO readById(Long no) {
        MemberDTO member = null;
        Optional<Member> result = memberRepository.findById(no);
        if(result.isPresent()) {
            member = entityToDto(result.get());
        }
        return member;
    }

    @Override
    public MemberDTO loginById(MemberDTO memberDTO) {
        MemberDTO member = null;
        Object result = memberRepository.getMemberById(memberDTO.getId(), memberDTO.getPassword());
        if(result != null) {
            member = entityToDto((Member) result);
        }
        return member;
    }

    private MemberDTO entityToDto(Member entity){
        MemberDTO memberDTO = MemberDTO.builder()
                .no(entity.getNo())
                .address(entity.getAddress())
                .birth(entity.getBirth())
                .email(entity.getEmail())
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .phone(entity.getPhone())
                .build();
             return memberDTO;
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
