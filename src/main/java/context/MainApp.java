package context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("context");
        Cart cart = context.getBean(Cart.class);
        cart.printCart();
        ProductRepository pr = context.getBean(ProductRepository.class);
        System.out.println("Добро пожаловать в smallShop");
        Scanner sc = new Scanner(System.in);
        pr.printProductsList();
        String str;

        do {
            str = sc.nextLine();
            char[] tmp = str.toCharArray();
            Long p = Long.parseLong(String.valueOf(tmp[1]));

            if (tmp[0] == '+') {
                cart.addProductToCart(p);
                System.out.println("вы купили " + pr.getProductById(p));
                System.out.println("Сейчас в корзине:");
                cart.printCart();
            }
            if (tmp[0] == '-' && cart.isOnCart(pr.getProductById(p))) {
                cart.deleteProductToCart(p);
                System.out.println("вы убрали из корзины " + pr.getProductById(p));
                System.out.println("Сейчас в корзине:");
                cart.printCart();
            }
        }
        while (!str.equals("exit"));

    }
}





