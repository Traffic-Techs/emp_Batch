package com.example.empbatch.naverAPI;

import com.example.empbatch.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {
}
