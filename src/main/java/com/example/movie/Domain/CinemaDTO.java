package com.example.movie.Domain;

import lombok.Builder;
import lombok.Data;

@Data //@Getter, @Setter, @EqualsAndHash, @RequiredArgsConstructor
@Builder
public class CinemaDTO {
    private Long ci_no;
    private String name;
    private String seat;


}
