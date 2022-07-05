package com.example.movie.Entity;

import lombok.*;

import javax.persistence.*;

@Entity // Spring Data JPA의 엔티티(entity, 개체)임을 나타냄
@Table(name="Cinema")
// Lombok Annotation
@ToString // toString() 생성
@Getter // getter() 생성0
@Setter //setter() 추가
@Builder
@AllArgsConstructor // 모든 매개변수를 갖는 생성자
@NoArgsConstructor // 디폴트 생성자(아무런 매개변수가 없는)
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ci_no;

    @Column(name = "seat", nullable = false)
    private String seat;
}
