//package com.example.empbatch.util;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import jakarta.annotation.PostConstruct;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SearchWord {
//
//  public static List<String> searchList = new ArrayList<>();
//
//  @PostConstruct
//  public void init() throws InterruptedException {
//
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("--start-maximized");
//    options.addArguments("headless");
//
//    WebDriver driver = new ChromeDriver(options);
//
//    String url = "https://datalab.naver.com/home/sectionSearch.naver";
//    driver.get(url);
//
//    driver.findElement(By.xpath("//*[@id='content']/div[1]/div[3]/div[1]")).click();
//    driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[3]/div[1]/ul/li[4]/a")).click();
//    Thread.sleep(10000);
//
//    List<WebElement> rankInnerElements = driver.findElements(By.cssSelector(".rank_inner.v2"));
//    if (!rankInnerElements.isEmpty()) {
//      WebElement lastElement = rankInnerElements.get(rankInnerElements.size() - 1);
//      List<WebElement> listAreaElements = lastElement.findElements(By.className("list_area"));
//
//      for (WebElement listAreaElement : listAreaElements) {
//        String word = listAreaElement.getText();
//        searchList.add(word);
//      }
//    }
//
//    if (driver != null) {
//      driver.quit();
//    }
//  }
//
//
//
//}
