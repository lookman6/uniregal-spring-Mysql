package com.gestionbuvette.uniregal.repositories;

import com.gestionbuvette.uniregal.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
