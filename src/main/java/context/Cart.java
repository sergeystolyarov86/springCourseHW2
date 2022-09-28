package context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@Scope("prototype")
public class Cart {

    @Autowired
    private ProductRepository repository;

    private List<Product> cartList;

    @PostConstruct
    public void init() {
        cartList = new ArrayList<>();
    }

    public Cart(List<Product> cartList) {
        this.cartList = cartList;
    }

    public void addProductToCart(Long id) {
        cartList.add(repository.getProductById(id));
    }

    public void deleteProductToCart(Long id) {
        cartList.removeIf(p -> p.id.equals(id));
    }

    public void printCart() {
        cartList.forEach(System.out::println);
    }

    public boolean isOnCart(Product product){
      return   cartList.contains(product);
    }
}
