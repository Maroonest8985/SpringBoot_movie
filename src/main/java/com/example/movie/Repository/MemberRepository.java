package com.example.movie.Repository;

import com.example.movie.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface MemberRepository extends JpaRepository<Member, Long>{
    @Query("select m from Member m where m.id = :id and m.password = :pw")
    Object getMemberById(@Param("id") String id, @Param("pw") String password);

    @Transactional
    @Modifying
    void deleteMemberByNo(Long no);
}
