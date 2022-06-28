package ru.netology.productManager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    Product product1 = new Product(01, "Ваза", 1000);
    Book book1 = new Book(02, "Книга", 500, "Акунин");
    Smartphone smartphone1 = new Smartphone(03, "Телефон", 5000, "Xiaomi");
    Product product2 = new Product(04, "Стол", 1000);
    Book book2 = new Book(05, "Книга", 1000, "Чейз");
    Smartphone smartphone2 = new Smartphone(06, "Телефон", 5000, "Samsung");

    @Test
    public void shouldAdd() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(product1);
        manager.add(book2);
        manager.add(smartphone1);
        Product[] actual = repository.findAll();
        Product[] expected = {product1, book2, smartphone1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteById() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(product2);
        manager.add(book1);
        manager.add(smartphone2);
        manager.removeById(06);
        Product[] actual = repository.findAll();
        Product[] expected = {product2, book1};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(product1);
        manager.add(product2);
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Телефон");
        Product[] expected = {smartphone1, smartphone2};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByWhenNoProducts() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        Product[] actual = manager.searchBy("Телефон");
        Product[] expected = new Product[0];
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchByWhenOneProduct() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("Телефон");
        Product[] expected = {smartphone2};
        assertArrayEquals(expected, actual);

    }

}
