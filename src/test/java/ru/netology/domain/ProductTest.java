package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    private Product product = new Product();
    private Book book = new Book();
    private ProductRepository productRepository= new ProductRepository();
    private ProductManager manager = new ProductManager(productRepository);

    private Smartphone first = new Smartphone(1,"version1",12,"LG");
    private Smartphone second = new Smartphone(2,"IpxoneXR",13,"Apple");
    private Smartphone third = new Smartphone(3,"A0",16,"Samsung");
    private Book fourth = new Book(4,"PortraitOfDorianGray",23,"OscarWilde");
    private Book fifth = new Book(5, "OrdinaryStory",17,"IvanAlexandrovichGoncharov");
    private Book sixth = new Book(6, "TheManWhoLaughs",19,"VictorMarieHugo");




}