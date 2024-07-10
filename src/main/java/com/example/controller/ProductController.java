package com.example.controller;


import com.example.entity.Product;
import com.example.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
//con esto especificamos la ruta de este controlador. va a escuchar la URL products
@RequestMapping("/products")
public class ProductController {

    //bean
    public ProductRepository repository;

    //inyectamos el bean ProductRepositoru con constructor para facilitar el testing

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }



    //metodos propios


    /*
    GET http://localhost:8080/products
    * */
    @GetMapping()
    //model es una clase que va a permitir cargar datos.
    //1. Inyectamos asi pues el Modelo (del MVC) -----------------------------------------------------------MODELO
    //2. Este model lo cargamos con datos, que normalmente vienen con bases de datos con addAtribute
    //3. Devolvemos la vista (archivo html "product-list") donde va a estar la interfaz de usuario------------VISTA
    //4. le controlador sería la clase entera ProductController ------------------------------------------CONTROLADOR

    //---------------------------------
    //esto haria que nos llegaria aqui una peticion http, cargamos unos datos en el modelo y redirigimos esa info a una vista return "...
    public String findAll(Model model){

        List<Product> products = this.repository.findAll();
        model.addAttribute("product", products);
        return "product-list";

    }


    /*
    GET http://localhost:8080/products/new
    * */

    //este seria un nuevo metodo para que  el usuario pueda introducir un nuevo producto. esta seria la nueva URL
    //devolverá un nuevo archivo "product-form"
    @GetMapping("/new")
    public String getForm(Model model){

        model.addAttribute("products", new Product());
        return "product-form";

    }


       /*
   Ahora entraría a este otro metodo despues de añadir el producto para guardarlo, en
    POST http://localhost:8080/products
    * */

    @PostMapping
    public String save (@ModelAttribute("product") Product product){
       this.repository.save(product);
        return "redirect:/products";

    }


    /* crear pantalla para view para ver los productos . creamos un PLACEHOLDER para que vaya cualquier numero {id}
    GET http://localhost:8080/products/{id}/view
    *
   */

    /* crear pantalla para un update para la edicion de productos
    GET http://localhost:8080/products/{id}/edit
    * */

    /* crear pantalla para borrar ube producto
    GET http://localhost:8080/products/{id}/delete
    * */






}
