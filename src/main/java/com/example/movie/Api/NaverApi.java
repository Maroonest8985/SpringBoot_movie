package com.example.movie.Api;


import com.example.movie.Domain.MoviesDto;
import com.example.movie.Domain.MoviesResponseDto;
import com.nimbusds.jose.shaded.json.parser.ParseException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.nimbusds.jose.shaded.json.parser.JSONParser;

import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

@Service
@RequiredArgsConstructor
public class NaverApi {
    private final RestTemplate restTemplate;

    private final String CLIENT_ID = "g9QQjkXvUYMiIFen1vy4";//ID
    private final String CLIENT_SECRET = "LbFRz8oiUJ";//key

    private final String OpenNaverMovieUrl_getMovies = "https://openapi.naver.com/v1/search/movie.json?query={keyword}";


    public MoviesResponseDto requestMovie(String keyword) {
        final HttpHeaders headers = new HttpHeaders(); // 헤더에 key들을 담아준다.
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);


        final HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange(OpenNaverMovieUrl_getMovies, HttpMethod.GET, entity, MoviesResponseDto.class, keyword).getBody();
    }

    private String get(String apiUrl, Map<String, String> requestHeaders) {
        HttpURLConnection con = connect(apiUrl);
        try {
            con.setRequestMethod("GET");
            for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
                return readBody(con.getInputStream());
            } else { // 에러 발생
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private HttpURLConnection connect(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection) url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    private static String readBody(InputStream body) {
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }

    public List<MoviesDto> naverMovie(String text) throws ParseException {

        try {
            text = URLEncoder.encode(" 검색어 ", "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("검색어 인코딩 실패", e);
        }
        String apiURL = "https://openapi.naver.com/v1/search/movie?query=" + text;
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("X-Naver-Client-Id", CLIENT_ID);
        requestHeaders.put("X-Naver-Client-Secret", CLIENT_SECRET);

        String responseBody = get(apiURL, requestHeaders);//get(apiURL, requestHeaders);
        String json = responseBody;

        JSONParser parser = new JSONParser();
        JSONObject obj = (JSONObject) parser.parse(json);
        JSONArray item = (JSONArray) obj.get("items");
        List<MoviesDto> list = null;
        list = new ArrayList<MoviesDto>();

        for (int i = 0; i < item.size(); i++) {
            MoviesDto m = new MoviesDto();
            JSONObject tmp = (JSONObject) item.get(i);
            String title = (String) tmp.get("title");
            String image = (String) tmp.get("image");
            String actor = (String) tmp.get("actor");
            String link = (String) tmp.get("link");
            String subtitle = (String) tmp.get("subtitle");
            Date pubDate = (Date) tmp.get("pubDate");
            Float userRating = (Float) tmp.get("userRating");
            String director = (String) tmp.get("director");
            m.setTitle(title);
            m.setImage(image);
            m.setActor(actor);
            m.setLink(link);
            m.setPubDate(pubDate);
            m.setSubtitle(subtitle);
            m.setUserRating(userRating);
            m.setDirector(director);

            m.setSubtitle(subtitle);
            if (m != null) list.add(m);
        }
        for (MoviesDto movie : list) {
            System.out.println(movie.getTitle());
        }

        return list;
    }
}



