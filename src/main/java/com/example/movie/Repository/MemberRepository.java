package com.example.movie.Repository;

import com.example.movie.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member, Long>{
    @Query("select m from Member m where m.email = :email and m.password = :pw")
    Object getMemberByEmail(@Param("email") String email, @Param("pw") String pw);
}
