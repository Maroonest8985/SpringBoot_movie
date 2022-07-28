package com.example.movie.Entity;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="Movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*박스오피스 종류*/
    private String boxofficeType;

    /*박스오피스 조회 일자*/
    private String showRange;

    /*순번*/
    private String rnum;

    /*해당일자의 박스오피스 순위*/
    private String rank;

    /*전일대비 순위의 증감분*/
    private String rankInten;

    /*랭킹에 신규진입여부 “OLD” : 기존 , “NEW” : 신규*/
    private String rankOldAndNew;

    /*영화의 대표코드*/
    private String movieCd;

    /*영화명(국문)*/
    private String movieNm;

    /*영화의 개봉일*/
    private String openDt;

    /*해당일의 매출액*/
    private String salesAmt;

    /*해당일자 상영작의 매출총액 대비 해당 영화의 매출비율*/
    private String salesShare;

    /*전일 대비 매출액 증감분*/
    private String salesInten;

    /*전일 대비 매출액 증감 비율*/
    private String salesChange;

    /*누적매출액*/
    private String salesAcc;

    /*해당일의 관객수*/
    private String audiCnt;

    /*전일 대비 관객수 증감분*/
    private String audiInten;

    /*전일 대비 관객수 증감 비율*/
    private String audiChange;

    /*누적관객수*/
        private String audiAcc;

    /*해당일자에 상영한 스크린수*/
    private String scrnCnt;

    /*해당일자에 상영된 횟수*/
    private String showCnt;

    /*DB 저장 일자*/
    private String targetDt;

    /*이미지 주소 form NaverApi*/
    private String imgSrc;

    @CreationTimestamp
    private LocalDateTime modification_date_time;

}
