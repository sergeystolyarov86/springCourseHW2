package context;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 50),
                new Product(2L, "Milk", 80),
                new Product(3L, "Orange", 100),
                new Product(4L, "Tea", 75),
                new Product(5L, "Sugar", 60)
        ));
    }


    public void printById(Long id) {
        System.out.println(products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow());
    }

    public Product getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst().orElseThrow();
    }

    public void printProductsList() {
        products.forEach(System.out::println);
    }

}
