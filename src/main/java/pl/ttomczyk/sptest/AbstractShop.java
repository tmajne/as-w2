package pl.ttomczyk.sptest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
abstract public class AbstractShop implements Shop {

    protected List<Product> cart;

    public AbstractShop() {
        this.cart = new ArrayList<Product>();
    }

    @Override
    public void addToCart(Product product) {
        this.cart.add(product);
    }

    @Override
    public void showCart() {
        this.cart.forEach(System.out::println);
        System.out.println("Total price: " + this.cartPrice());
    }

    protected int cartPrice() {
        int totalPrice = 0;
        for (Product product : this.cart) {
            totalPrice += product.getPrice();
        }
        return  totalPrice;
    }
}
