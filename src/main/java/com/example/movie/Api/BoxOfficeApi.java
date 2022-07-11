package com.example.movie.Api;

import com.example.movie.Entity.Movie;
import com.example.movie.Repository.DailyMovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.nimbusds.jose.shaded.json.parser.JSONParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BoxOfficeApi {

    private final DailyMovieRepository dailyMovieRepository;

    //발급키
    String key = "3ab83bf06ebbff20eab7fc271423bc42";

    public void dailyBoxOffice(){

        String dailyResponse = "";

        //전날 박스오피스 조회 ( 오늘 날짜꺼는 안나옴.. )
        LocalDateTime time = LocalDateTime.now().minusDays(1);
        String targetDt =  time.format(DateTimeFormatter.ofPattern("yyyMMdd"));
        dailyMovieRepository.deleteMoviesByTargetDtNotLike(targetDt); // 오늘자 제외하고 삭제

        //ROW 개수
        String itemPerPage = "10";

        //다양성영화(Y)/상업영화(N)/전체(default)
        String multiMovieYn = "N";

        //한국영화(K)/외국영화(F)/전체(default)
        String repNationCd = "";

        //상영지역별 코드/전체(default)
        String wideAreaCd = "";

        try {

            // KOBIS 오픈 API Rest Client를 통해 호출
            KobisOpenAPIRestService service = new KobisOpenAPIRestService(key);

            // 일일 박스오피스 서비스 호출 (boolean isJson, String targetDt, String itemPerPage,String multiMovieYn, String repNationCd, String wideAreaCd)
            dailyResponse = service.getDailyBoxOffice(true, targetDt, itemPerPage, multiMovieYn, repNationCd, wideAreaCd);

            //JSON Parser 객체 생성
            JSONParser jsonParser = new JSONParser();

            //Parser로 문자열 데이터를 객체로 변환
            Object obj = jsonParser.parse(dailyResponse);

            //파싱한 obj를 JSONObject 객체로 변환
            JSONObject jsonObject = (JSONObject) obj;

            //차근차근 parsing하기
            JSONObject parse_boxOfficeResult = (JSONObject) jsonObject.get("boxOfficeResult");

            //박스오피스 종류
            String boxofficeType = (String) parse_boxOfficeResult.get("boxofficeType");

            //박스오피스 조회 일자
            String showRange = (String) parse_boxOfficeResult.get("showRange");

            ObjectMapper objectMapper = new ObjectMapper();
            JSONArray parse_dailyBoxOfficeList = (JSONArray) parse_boxOfficeResult.get("dailyBoxOfficeList");
            for(int i=0; i<parse_dailyBoxOfficeList.size(); i++){
                JSONObject dailyBoxOffice = (JSONObject) parse_dailyBoxOfficeList.get(i);

                //JSON object -> Java Object(Entity) 변환
                Movie dailyMovie = objectMapper.readValue(dailyBoxOffice.toString(), Movie.class);
                String movieCd = dailyMovie.getMovieCd();
                List<String> movieList = dailyMovieRepository.findAllByMovieCd(movieCd);//업데이트
                System.out.println(movieList);
                //DB저장
                if(movieList.isEmpty() == true){//영화가 겹치나? 안겹치면->
                    dailyMovie.setTargetDt(targetDt);
                    dailyMovie.setBoxofficeType(boxofficeType);
                    dailyMovie.setShowRange(showRange);
                    dailyMovieRepository.save(dailyMovie);
                }else{

                }
            }
        }catch(Exception e){
            e.getMessage();
        }
    }
}