package com.example.empbatch.naver.service;

import com.example.empbatch.naver.dto.ItemDto;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.time.LocalDateTime;

@Slf4j(topic = "NAVER API")
@Service
public class NaverApiService {

  private final RestTemplate restTemplate;

  public NaverApiService(RestTemplateBuilder builder) {
    this.restTemplate = builder.build();
  }

  public List<ItemDto> searchItems(String query) {
    int itemsPerPage = 100;  // 한 페이지에 표시할 아이템 수
    List<ItemDto> allItems = new ArrayList<>();  // 모든 페이지의 아이템을 저장할 리스트

    // 저장 디렉토리 설정
    String directionPath = "C:\\Users\\abc\\IdeaProjects\\FirstJava\\empBatch\\시간별 인기상품 데이터";
    File directory = new File(directionPath);
    if (!directory.exists()) {
      directory.mkdirs(); // 디렉토리가 없으면 생성
    }

    // 현재 조회한 JSON 저장
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    LocalDateTime timestamp = LocalDateTime.now();
    String formattedTimestamp = timestamp.format(formatter);
    String fileName = "naverData" + formattedTimestamp + ".json";
    File file = new File(directory, fileName);

    try (FileWriter writer = new FileWriter(file)) {
      for (int start = 1; start <= 999; start += itemsPerPage) {
        // 요청 URL 만들기
        URI uri = UriComponentsBuilder
            .fromUriString("https://openapi.naver.com")
            .path("/v1/search/shop.json")
            .queryParam("display", itemsPerPage)
            .queryParam("query", query)
            .queryParam("start", start)
            .queryParam("sort", "date")
            .encode()
            .build()
            .toUri();
        log.info("uri = " + uri);

        RequestEntity<Void> requestEntity = RequestEntity
            .get(uri)
            .header("X-Naver-Client-Id", "RjS29HILpZi4rAGkqMPA")
            .header("X-Naver-Client-Secret", "9PwvGKyX2p")
            .build();

        ResponseEntity<String> responseEntity = restTemplate.exchange(requestEntity, String.class);

        log.info("NAVER API Status Code : " + responseEntity.getStatusCode());

        List<ItemDto> items = fromJSONtoItems(responseEntity.getBody());
        allItems.addAll(items);

        String jsonResponse = responseEntity.getBody();
        writer.write(jsonResponse);

        // API 제한 속도를 고려하여 적절한 대기 시간을 설정
        try {
          Thread.sleep(1000);  // 1초 대기
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return allItems;
  }

  public List<ItemDto> fromJSONtoItems(String responseEntity) {
    JSONObject jsonObject = new JSONObject(responseEntity);
    JSONArray items = jsonObject.getJSONArray("items");
    List<ItemDto> itemDtoList = new ArrayList<>();

    for (Object item : items) {
      ItemDto itemDto = new ItemDto((JSONObject) item);
      itemDtoList.add(itemDto);
    }

    return itemDtoList;
  }

}
