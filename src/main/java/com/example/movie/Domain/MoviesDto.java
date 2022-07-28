package com.example.movie.Domain;

import lombok.Data;

import java.util.Date;


@Data
public class MoviesDto {
    private int display;
    public String title; //제목
    public String link; //링크
    public String image; //이미지
    public String subtitle; //서브제목
    public Date pubDate; //검색 결과 영화의 제작년도이다.
    public String director; //감독
    public String actor; //배우
    public float userRating; //평점



}