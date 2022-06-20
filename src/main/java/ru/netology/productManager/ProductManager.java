package ru.netology.productManager;

import static java.util.regex.Pattern.matches;

public class ProductManager {
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }


    public Product[] searchBy(String search) {
        Product[] result = new Product[0];

        for (Product product : repository.findAll()) {
            if (product.name.matches(search)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }

        }
        return result;
    }
}