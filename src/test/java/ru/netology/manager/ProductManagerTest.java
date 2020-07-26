package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository productRepository= new ProductRepository();
    private ProductManager manager = new ProductManager(productRepository);
    private Product product = new Product();
    private Smartphone first = new Smartphone(1,"version1",12,"LG");
    private Smartphone second = new Smartphone(2,"IpxoneXR",13,"Apple");
    private Smartphone third = new Smartphone(3,"A0",16,"Samsung");
    private Book fourth = new Book(4,"PortraitOfDorianGray",23,"OscarWilde");
    private Book fifth = new Book(5, "OrdinaryStory",17,"IvanAlexandrovichGoncharov");
    private Book sixth = new Book(6, "TheManWhoLaughs",19,"VictorMarieHugo");

    @Test
    public void shouldBeFoundSmartphone(){// Следует найти смартфон
        manager.add(first);
        manager.matches(product,"version1");
        Product[] actual = manager.searchBy("version1");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldBeFoundBook(){// Следует найти книгу
        manager.add(fourth);
        manager.matches(product,"OscarWilde");
        Product[] actual = manager.searchBy("OscarWilde");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldBeFoundIfDoesNotExist1(){// Следует найти книгу по несуществующим данным
        manager.add(fourth);
        manager.searchBy("version2");
        Product[] actual = new Product[]{}; ;
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeFoundIfDoesNotExist2(){// Следует найти смартфон по несуществующим данным
        manager.add(second);
        manager.searchBy("Apple2");
        Product[] actual = new Product[]{}; ;
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldBeFound(){// Следует найти
        manager.add(first);
        manager.add(second);
        manager.add(fourth);
        manager.add(sixth);
        manager.searchBy("version1");
        manager.searchBy("Apple");
        manager.searchBy("OscarWilde");
        manager.searchBy("TheManWhoLaughs");

        Product[] actual = new Product[]{first,second,fourth,sixth};

        Product[] expected = new Product[]{first,second,fourth,sixth};
        assertArrayEquals(expected,actual);

    }

}

