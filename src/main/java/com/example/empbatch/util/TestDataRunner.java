package com.example.empbatch.util;

import com.example.empbatch.entity.Products;
import com.example.empbatch.naver.dto.ItemDto;
import com.example.empbatch.naver.service.NaverApiService;
import com.example.empbatch.repository.ProductRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataRunner implements ApplicationRunner {

  @Autowired
  ProductRepository productRepository;

  @Autowired
  NaverApiService naverApiService;

  @Override
  public void run(ApplicationArguments args) {
    createTestData("아이폰");
  }

  private void createTestData(String searchWord) {
    naverApiService.updateProducts(searchWord);
  }

}
