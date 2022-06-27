package com.example.movie.Repository;

import com.example.movie.Entity.Member;
import com.example.movie.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Movie, Long> {



}
