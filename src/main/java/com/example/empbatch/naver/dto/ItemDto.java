package com.example.empbatch.naver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Getter
@NoArgsConstructor
public class ItemDto {

  private String title;
  private String category;
  private String image;
  private Long price;

  public ItemDto(JSONObject itemJson) {
    this.title = itemJson.getString("title");
    this.category = itemJson.getString("category2");
    this.image = itemJson.getString("image");
    this.price = itemJson.getLong("lprice");
  }

}
