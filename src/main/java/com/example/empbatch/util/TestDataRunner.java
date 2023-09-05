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

    List<ItemDto> itemDtoList = naverApiService.searchItems(searchWord);

    List<Products> productList = new ArrayList<>();

    for (ItemDto itemDto : itemDtoList) {
      Products products = new Products();

      // 인기 검색어 관련 상품 업데이트
      products.setTitle(itemDto.getTitle());
      products.setCategory(itemDto.getCategory());
      products.setImages(itemDto.getImage());
      products.setCost(itemDto.getPrice());
      products.setAmount(generateRandomAmount());
      products.setRegister_date(LocalDateTime.now());
      products.setSale(true);

      productList.add(products);
    }

    productRepository.saveAll(productList);
  }

  private Long generateRandomAmount() {
    Random random = new Random();
    return (long) (random.nextInt(10000) + 1);
  }

}
