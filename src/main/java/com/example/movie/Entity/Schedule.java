package com.example.movie.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

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
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date time;
    @Column(name = "moviecd", nullable = false)
    private String moviecd;

    @OneToOne
    @JoinColumn(name="cinema")
    private Cinema cinema;


}