package com.example.empbatch.util;

import com.example.empbatch.naver.service.NaverApiService;
import com.example.empbatch.repository.ProductRepository;
import com.example.empbatch.searchWordCrawling.SearchWord;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
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

  @Override
  public void run(ApplicationArguments args) {
    List<String> searchList = searchWord.searchList;
    for (String searchItem : searchList) {
      createTestData(searchItem);
    }
  }

  private void createTestData(String searchWord) {
    naverApiService.updateProducts(searchWord);
  }

}
