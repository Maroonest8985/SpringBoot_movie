package com.example.movie.Service;

import com.example.movie.Api.NaverApi;
import com.example.movie.Domain.MoviesResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class MovieService {
    private final NaverApi naverApi;

    @Transactional(readOnly = true)
    public MoviesResponseDto findByKeyword(String keyword) {
        return naverApi.requestMovie(keyword);
    }


}
