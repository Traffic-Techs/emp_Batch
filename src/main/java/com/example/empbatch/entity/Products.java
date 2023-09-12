package com.example.empbatch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Products {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String images;

  @Column(nullable = false)
  private String description;

//  @Column(nullable = false)
//  private String category;

  @Column(nullable = false)
  private Long cost;

  @Column(nullable = false)
  private Long amount;

  @Column(nullable = false)
  private Boolean sale;

  @Builder
  public Products(String title, String images, String description, Long cost, Long amount,
      Boolean sale) {
    this.title = title;
    this.images = images;
    this.description = description;
    this.cost = cost;
    this.amount = amount;
    this.sale = sale;
  }
}
