package com.example.empbatch.util;

import com.example.empbatch.naverAPI.NaverApiService;
import com.example.empbatch.naverAPI.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateDataRunner implements ApplicationRunner {

  private final SearchWord searchWord;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  NaverApiService naverApiService;

  // 2시간마다 정보 업데이트
  @Scheduled(cron = "1 30 */2 * * *")
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
