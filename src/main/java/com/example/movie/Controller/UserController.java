package com.example.movie.Controller;


import com.example.movie.Api.KakaoApi;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private KakaoApi kakaoApi;

    @ResponseBody
    @GetMapping("/kakao/callback")
    public String  kakaoCallback(@RequestParam String code)  {

        String access_Token = kakaoApi.getKaKaoAccessToken(code);
        kakaoApi.createKakaoUser(access_Token);

        return "성공입니다";

    }

}
