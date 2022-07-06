package com.example.movie.Repository;

import com.example.movie.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KakaoRepository extends JpaRepository<User,Integer> {

}
