package com.example.empbatch.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

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
  private String category;

  @Column(nullable = false)
  private Long cost;

  @Column(nullable = false)
  private Long amount;

  @Column(nullable = false)
  @CreatedDate
  private LocalDateTime register_date;

  @Column(nullable = false)
  private Boolean sale;

  @Builder
  public Products(String title, String images, String category, Long cost, Long amount,
      LocalDateTime register_date, Boolean sale) {
    this.title = title;
    this.images = images;
    this.category = category;
    this.cost = cost;
    this.amount = amount;
    this.register_date = register_date;
    this.sale = sale;
  }
}
