package com.example.movie.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Data
@Table(name="Schedule")
@ToString // toString() 생성
@Getter // getter() 생성
@Setter //setter() 추가
@Builder
@AllArgsConstructor // 모든 매개변수를 갖는 생성자
@NoArgsConstructor // 디폴트 생성자(아무런 매개변수가 없는)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//스케쥴 번호
    private Long no;
    @Column(name = "date", nullable = false)//스케줄 날짜
    private String date;
    @Column(name = "time", nullable = false)//스케줄 시간
    private String time;


    @OneToOne
    @JoinColumn(name="cinema")
    private Cinema cinema;


    @OneToOne
    @JoinColumn(name = "movie")//영화 정보
    private Movie movie;
}