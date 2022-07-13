package com.example.movie.Domain;

import lombok.Builder;
import lombok.Data;

@Data //@Getter, @Setter, @EqualsAndHash, @RequiredArgsConstructor
@Builder

public class ScheduleDTO {
    private Long no;
    private String date;
    private String time;
    private String movieCd;
    private String cinema_no;
}
