package pl.ttomczyk.sptest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("Pro")
@ConfigurationProperties(prefix = "shop")
public class ShopPro extends AbstractShop {

    private int vat;
    private int discount;

    @Override
    public void showCart() {
        super.showCart();

        double vat = 1 + (double) this.vat / 100;
        double discount = (double) this.discount / 100;

        int totalPrice = this.cartPrice();

        System.out.println("Total price with VAT: " + totalPrice * vat);
        System.out.println("Total price with discount: " + (totalPrice -  totalPrice * discount));
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
