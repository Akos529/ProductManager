package ru.netology.productManager;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        for (int i = 0; i < products.length; i++) tmp[i] = products[i];
        int lastProduct = tmp.length - 1;
        tmp[lastProduct] = product;
        products = tmp;

    }

    public Product[] findAll() {
        return products;
    }

    public void deleteById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }

        }
        products = tmp;
    }
}
