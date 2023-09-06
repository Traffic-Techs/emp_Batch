package com.example.empbatch.util;

import com.example.empbatch.naver.service.NaverApiService;
import com.example.empbatch.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UpdateDataRunner implements ApplicationRunner {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  NaverApiService naverApiService;

  private final SearchWord searchWord;

  // 네이버 데이터랩 쇼핑몰 일일 인기 검색어 업데이트 : 11시
  @Scheduled(cron = "0 30 11 * * ?")
  @Override
  public void run(ApplicationArguments args) {
    List<String> searchList = searchWord.searchList;
    for (String searchItem : searchList) {
      updateNewData(searchItem);
    }
  }

  private void updateNewData(String searchWord) {
    naverApiService.updateProducts(searchWord);
  }

}
