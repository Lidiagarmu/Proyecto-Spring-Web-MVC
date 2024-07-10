package com.example;

import com.example.controller.ProductController;
import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class App {

    public static void main(String[] args) {

        //esto crearia los productos en el arranque de la aplicacion , podemos hacerlo con ubn archivo sql..
       ApplicationContext context = SpringApplication.run(App.class, args);

       //esto directamente introduce productos y al acceder a la URL nos los devuelva
      var repository = context.getBean(ProductRepository.class);

      //con este repository podemos crear productos

        //INSERTAMOS DATOS DEMO PARA PROBAR: creamos productos desde el main (podria ser con archivo sql por ejemplo)
        //id es null porque la crea automaticamente y de forma secuencial
        List<Product> products = List.of(
                new Product(null, "product1", 5.99, 11),
                new Product(null, "product2", 90.99, 12),
                new Product(null, "product3", 15.55, 34),
                new Product(null, "product4", 3.20, 22)
        );

        //guarda los products
        repository.saveAll(products);
    }

}
