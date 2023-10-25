package org.example.Repositroy;

import org.example.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositroy extends JpaRepository<Product, String> {
}
