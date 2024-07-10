package com.example.repository;

import com.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//extiende de Jpa... y le indicamos la clase Product con el tipo de dato de su clave primaria Long
public interface ProductRepository extends JpaRepository<Product, Long> {
}
