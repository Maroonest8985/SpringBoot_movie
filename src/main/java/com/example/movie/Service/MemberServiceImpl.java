package com.example.movie.Service;


import com.example.movie.Domain.MemberDTO;
import com.example.movie.Entity.Member;
import com.example.movie.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> readAll() {
        return memberRepository.findAll();
    }

    @Override
    public MemberDTO readById(Long no) {
        MemberDTO memberDTO = null;
        Optional<Member> result = memberRepository.findById(no);
        if(result.isPresent()) {
            memberDTO = entityToDto(result.get());
        }
        return memberDTO;
    }
    @Override
    public void create(MemberDTO member) {
        Member entity = dtoToEntity(member);
        memberRepository.save(entity);
    }

    @Override
    public void update(MemberDTO memberDTO) {
        Member member = dtoToEntity(memberDTO);
        memberRepository.save(member);
    }

    @Override
    public void delete(MemberDTO memberDTO) {
        Member member = dtoToEntity(memberDTO);
        memberRepository.deleteById(member.getNo());
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

    private MemberDTO entityToDto(Member entity){
        //entity를 dto로 만들어주는 메소드
        //만든이유: create find등의 메소드의 여러번(반복) 쓰기 귀찮고 편하게 쓰기 위해서
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
}
