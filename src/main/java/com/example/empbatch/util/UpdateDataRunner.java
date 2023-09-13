package com.example.empbatch.util;

import com.example.empbatch.naverAPI.NaverApiService;
import com.example.empbatch.naverAPI.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateDataRunner implements ApplicationRunner {

  @Autowired
  ProductRepository productRepository;
  @Autowired
  NaverApiService naverApiService;

  @Override
  public void run(ApplicationArguments args) {
    List<String> wordList = new ArrayList<>();
      wordList.add("스마트폰");
      wordList.add("노트북");
      wordList.add("태블릿");
      wordList.add("무선 이어폰");
      wordList.add("스마트 워치");
      wordList.add("게이밍 노트북");
      wordList.add("TV");
      wordList.add("냉장고");
      wordList.add("세탁기");
      wordList.add("에어컨");
      wordList.add("가전제품");
      wordList.add("블루투스 스피커");
      wordList.add("카메라");
      wordList.add("드론");
      wordList.add("컴퓨터 모니터");
      wordList.add("프린터");
      wordList.add("스마트홈 기기");
      wordList.add("무선 충전기");
      wordList.add("헤드폰");
      wordList.add("마우스");
      wordList.add("키보드");
      wordList.add("그래픽 카드");
      wordList.add("주변기기");
      wordList.add("블랙프라이데이 할인");
      wordList.add("사이버먼데이 세일");
      wordList.add("플레이스테이션");
      wordList.add("엑스박스");
      wordList.add("닌텐도 스위치");
      wordList.add("VR 헤드셋");
      wordList.add("게이밍 모니터");
      wordList.add("스마트카메라");
      wordList.add("스트리밍 미디어 플레이어");
      wordList.add("사무용 가전제품");
      wordList.add("무선 라우터");
      wordList.add("스마트 조명");
      wordList.add("스마트 플러그");
      wordList.add("미니 프로젝터");
      wordList.add("스마트 서큘레이터 팬");
      wordList.add("블루레이 플레이어");
      wordList.add("전자책 리더");
      wordList.add("전자담배");
      wordList.add("소음 캔슬링 헤드폰");
      wordList.add("무선 이어버드");
      wordList.add("모바일 액세서리");
      wordList.add("카메라 렌즈");
      wordList.add("드릴/전동공구");
      wordList.add("청소 로봇");
      wordList.add("무선 스틱 청소기");
      wordList.add("믹서기/블렌더");
      wordList.add("에어 프라이어");
      wordList.add("스마트 냄비");
      wordList.add("전자레인지");
      wordList.add("소형 주방 가전");
      wordList.add("자동차용 전자제품");
      wordList.add("무선 헤드셋");
      wordList.add("스마트 카");
      wordList.add("외장 하드 드라이브");
      wordList.add("메모리 카드");
      wordList.add("스마트폰 케이스");
      wordList.add("태블릿 액세서리");
      wordList.add("노트북 가방");
      wordList.add("웹캠");
      wordList.add("홈시어터 시스템");
      wordList.add("무선 이어폰 케이스");
      wordList.add("블루투스 마우스");
      wordList.add("스마트 배터리 팩");
      wordList.add("GPS 장치");
      wordList.add("무인 경비 카메라");
      wordList.add("무선 이동식 충전기");
      wordList.add("전자식 온도계");
      wordList.add("스마트 미러");
      wordList.add("웨어러블 기기");
      wordList.add("무선 블루투스 키보드");
      wordList.add("스마트 스캔");
      wordList.add("스마트 터치 스크린 모니터");
      wordList.add("무선 블루투스 이어폰");
      wordList.add("무선 이어폰 어댑터");
      wordList.add("스마트 온도 조절기");
      wordList.add("스마트 워크아웃 장비");
      wordList.add("카메라 드론");
      wordList.add("미니 스피커");
      wordList.add("전자식 주방 저울");
      wordList.add("무선 키보드 및 마우스 세트");
      wordList.add("무선 터치패드");
      wordList.add("사운드바");
      wordList.add("무선 블루투스 스피커");
      wordList.add("마이크로폰");
      wordList.add("화면보호 필름");
      wordList.add("전기 칫솔");
      wordList.add("무선 라벨 프린터");
      wordList.add("무선 헤드셋 어댑터");
      wordList.add("전자식 체중계");
      wordList.add("무선 터치 스크린 스마트 스피커");
      wordList.add("스마트폰 홀더");
      wordList.add("스마트폰 삼각대");
      wordList.add("액션 카메라");
      wordList.add("게임 컨트롤러");
      wordList.add("플레이스테이션 액세서리");
      wordList.add("엑스박스 액세서리");
      wordList.add("닌텐도 스위치 액세서리");
    for (String wordItem : wordList) {
      updateNewData(wordItem);
    }
  }

  private void updateNewData(String searchWord) {
    naverApiService.updateProducts(searchWord);
  }
}
