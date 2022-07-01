package com.example.movie.Domain;

import lombok.Builder;
import lombok.Data;

@Data //@Getter, @Setter, @EqualsAndHash, @RequiredArgsConstructor
@Builder

public class MemberDTO {
    private Long no;
    private String username;
    private String id;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String birth;
}
