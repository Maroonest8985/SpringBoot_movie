package com.example.movie.Service;

import com.example.movie.Api.NaverApi;
import com.example.movie.Domain.MoviesDto;
import com.example.movie.Domain.MoviesResponseDto;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final NaverApi naverApi;

    @Transactional(readOnly = true)
    public MoviesResponseDto findByKeyword(String keyword) {
        return naverApi.requestMovie(keyword);
    }

    @Transactional(readOnly = true)
    public MoviesDto findByKeyword2(String keyword) throws ParseException {

        return naverApi.naverMovie(keyword);
    }


}
