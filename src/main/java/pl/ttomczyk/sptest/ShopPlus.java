package pl.ttomczyk.sptest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Plus")
public class ShopPlus extends AbstractShop {

    @Value("${shop.vat}")
    private int vat;

    @Override
    public void showCart() {
        super.showCart();

        double vat = 1 + (double) this.vat / 100;
        int totalPrice = this.cartPrice();

        System.out.println("Total price with VAT: " + totalPrice * vat);
    }
}
