package com.example.movie.Entity;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Reserve")
@ToString // toString() 생성
@Getter // getter() 생성
@Setter //setter() 추가
@Builder
@AllArgsConstructor // 모든 매개변수를 갖는 생성자
@NoArgsConstructor // 디폴트 생성자(아무런 매개변수가 없는)
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//예약번호
    private Long no;
    @Column(name = "date", nullable = false)//예약일, 시간
    private LocalDateTime date;
    @Column(name = "num", nullable = false)//인원수
    private String num;
    @Column(name = "seat", nullable = false)//좌석정보-"A1, A2"
    private String seat;



    @ManyToOne
    @JoinColumn(name = "member")//예약 회원정보
    private Member member;

    @ManyToOne
    @JoinColumn(name = "movie")//예약 영화정보
    private Movie movie;


}
