package context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("context");
        Cart cart = context.getBean(Cart.class);
        ProductRepository pr = context.getBean(ProductRepository.class);
        System.out.println("Products:");
        pr.printProductsList();
        System.out.println("______________________________________________");
        cart.addProductToCart(2l);
        cart.addProductToCart(4l);
        cart.printCart();
        cart.deleteProductToCart(2l);
        cart.printCart();

    }
}
